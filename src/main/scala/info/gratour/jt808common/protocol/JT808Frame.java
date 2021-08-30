package info.gratour.jt808common.protocol;

import io.netty.buffer.ByteBuf;

import java.io.Closeable;

public class JT808Frame implements Closeable {

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
}
