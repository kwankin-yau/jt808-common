package info.gratour.jt808common.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCounted;

import java.io.Closeable;

public class JT808Frame implements Closeable, ReferenceCounted {

    private JT808FrameHeader header;
    private ByteBuf body;

    public JT808FrameHeader getHeader() {
        return header;
    }

    public void setHeader(JT808FrameHeader header) {
        this.header = header;
    }

    public ByteBuf getBody() {
        return body;
    }

    public void setBody(ByteBuf body) {
        this.body = body;
    }


    @Override
    public void close() {
        body.release();
    }

    @Override
    public String toString() {
        return "JT808Frame{" +
                "header=" + header +
                ", bodySize=" + (body != null ? body.readableBytes() : 0) +
                '}';
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
}
