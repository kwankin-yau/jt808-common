package info.gratour.jt808common.codec.decoder;

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment;
import info.gratour.jt808common.protocol.FrameSplitInfo;
import info.gratour.jt808common.protocol.JT808Frame;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;

import java.io.Closeable;

public class JT808FramesCollector implements Closeable, CollectedFragment {


    private final int msgId;
    private JT808Frame[] frames;
    private int totalCount;
    private int recvCount;
    private final ByteBufAllocator allocator;

    public JT808FramesCollector(ByteBufAllocator allocator, int msgId) {
        this.allocator = allocator;
        this.msgId = msgId;
    }

    public boolean collect(JT808Frame frame) {
        FrameSplitInfo splitInfo = frame.getHeader().getSplitInfo();

        if (frames == null) {
            totalCount = splitInfo.getTotalPacket();
            if (totalCount == 0) {
                frame.release();
                throw new RuntimeException("Invalid total packet count.");
            }

            frames = new JT808Frame[totalCount];
        }

        int index = splitInfo.getPacketSeqNo() - 1;
        if (index >= totalCount) {
            frame.release();
            throw new RuntimeException("Invalid packet index.");
        }

        if (frames[index] == null) {
            recvCount++;
        } else
            frames[index].release();

        frames[index] = frame;

        return isAllFragmentReceived();
    }

    public JT808Frame buildWholePacket() {
        if (recvCount == 0)
            throw new IllegalStateException();

        CompositeByteBuf body = allocator.compositeBuffer(recvCount);

        for (int i = 0; i < recvCount; i++) {
            body.addComponent(true, frames[i].getBody().retain());
        }

        JT808Frame frame = new JT808Frame();
        frame.setHeader(frames[0].getHeader());
        frame.setBody(body);

        return frame;
    }

    @Override
    public synchronized void close() {
        if (frames != null) {
            for (int i = 0; i < frames.length; i++) {
                if (frames[i] != null) {
                    frames[i].close();
                    frames[i] = null;
                }
            }
            frames = null;
        }
    }

    @Override
    public JT808Frame[] getFrames() {
        return frames;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getRecvCount() {
        return recvCount;
    }

    @Override
    public boolean isAllFragmentReceived() {
        return recvCount == totalCount;
    }

    @Override
    public int getMsgId() {
        return msgId;
    }

}
