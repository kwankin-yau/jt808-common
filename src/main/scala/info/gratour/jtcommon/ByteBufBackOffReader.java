package info.gratour.jtcommon;

import io.netty.buffer.ByteBuf;
import org.apache.commons.codec.binary.Hex;

/**
 * An object keep current readerIndex of the ByteBuf and then read later.
 */
public class ByteBufBackOffReader implements LazyBytesProvider {

    private final ByteBuf buf;
    private final int originalReaderIndex;
    private final int sz;

    private byte[] _binary;
    private String _hex;

    public ByteBufBackOffReader(ByteBuf buf) {
        this.buf = buf;
        originalReaderIndex = buf.readerIndex();
        sz = buf.readableBytes();
    }

    @Override
    public byte[] binary() {
        if (_binary == null) {
            _binary = new byte[sz];
            buf.getBytes(originalReaderIndex, _binary);
        }

        return _binary;
    }

    @Override
    public String hex() {
        if (_hex == null)
            _hex = Hex.encodeHexString(binary());

        return _hex;
    }

    public ByteBuf slice() {
        return buf.slice(originalReaderIndex, sz);
    }
}
