/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtcommon;

import io.netty.buffer.ByteBuf;
import org.apache.commons.codec.binary.Hex;

public class NettyUtils {

    public static String decodeLenPrefixedString(ByteBuf buf) {
        int l = buf.readUnsignedByte();
        byte[] bytes = new byte[l];
        buf.readBytes(bytes);
        return new String(bytes, JTConsts$.MODULE$.DEFAULT_CHARSET());
    }

    public static void encodeLenPrefixedString(String s, ByteBuf out) {
        byte[] bytes = s.getBytes(JTConsts$.MODULE$.DEFAULT_CHARSET());
        int l = bytes.length;
        if (l > 255) {
            throw new RuntimeException("Too long string: " + s + ".");
        } else {
            out.writeByte(l);
            out.writeBytes(bytes);
        }
    }

//    @Deprecated
//    public static String byteBufToHexString(ByteBuf buf) {
//        int size = buf.readableBytes();
//        byte[] bytes = new byte[size];
//        buf.readBytes(bytes);
//        return Hex.encodeHexString(bytes);
//    }

    /**
     * Short name for byteBufToHexStringKeepReaderIndex
     *
     * @param buf
     * @return
     */
    public static String bufToHex(ByteBuf buf, boolean keepReaderIndex) {
        if (keepReaderIndex) {
            int readerIndex = buf.readerIndex();
            int size = buf.readableBytes();
            byte[] bytes = new byte[size];
            buf.readBytes(bytes);
            buf.readerIndex(readerIndex);
            return Hex.encodeHexString(bytes);
        } else {
            int size = buf.readableBytes();
            byte[] bytes = new byte[size];
            buf.readBytes(bytes);
            return Hex.encodeHexString(bytes);
        }
    }

    public static String bufToHex(ByteBuf buf) {
        return bufToHex(buf, true);
    }

    public static byte[] toByteArray(ByteBuf buf) {
        if (buf.hasArray())
            return buf.array();
        else {
            byte[] r = new byte[buf.readableBytes()];
            buf.readBytes(r);

            return r;
        }

    }

//    public static String bufToHex(ByteBuf buf, boolean keepReaderIndex) {
//        if (keepReaderIndex) {
//            int readerIndex = buf.readerIndex();
//            int size = buf.readableBytes();
//            byte[] bytes = new byte[size];
//            buf.readBytes(bytes);
//            buf.readerIndex(readerIndex);
//            return Hex.encodeHexString(bytes);
//        } else {
//            int size = buf.readableBytes();
//            byte[] bytes = new byte[size];
//            buf.readBytes(bytes);
//            return Hex.encodeHexString(bytes);
//        }
//    }
//
//    public static String bufToHex(ByteBuf buf) {
//        return bufToHex(buf, true);
//    }


//    public static String byteBufToHexStringKeepReaderIndex(ByteBuf buf) {
//        return bufToHex(buf);
//    }

}
