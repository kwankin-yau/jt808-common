package info.gratour.jt808common.protocol;

import info.gratour.jtcommon.ByteBufBackOffReader;
import info.gratour.jtcommon.LazyBytesProvider;
import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCounted;

import java.io.Closeable;
import java.util.StringJoiner;

public class JT808Frame implements Closeable, ReferenceCounted {

    private final JT808FrameHeader header;
    private final ByteBuf body;
    private final ByteBufBackOffReader backOffReader;

    public JT808Frame(JT808FrameHeader header, ByteBuf body) {
        this.header = header;
        this.body = body;
        this.backOffReader = new ByteBufBackOffReader(body);
    }

    public JT808FrameHeader getHeader() {
        return header;
    }

    public ByteBuf getBody() {
        return body;
    }


    @Override
    public void close() {
        body.release();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Frame.class.getSimpleName() + "[", "]")
                .add("header=" + header)
                .add("body=" + body)
                .add("backOffReader=" + backOffReader)
                .toString();
    }

    @Override
    public int refCnt() {
        return body.refCnt();
    }

    @Override
    public JT808Frame retain() {
        body.retain();
        return this;
    }

    @Override
    public JT808Frame retain(int increment) {
        body.retain(increment);
        return this;
    }

    @Override
    public JT808Frame touch() {
        body.touch();
        return this;
    }

    @Override
    public JT808Frame touch(Object hint) {
        body.touch(hint);
        return this;
    }

    @Override
    public boolean release() {
        return body.release();
    }

    @Override
    public boolean release(int decrement) {
        return body.release(decrement);
    }

    public ByteBufBackOffReader getBackOffReader() {
        return backOffReader;
    }
}
