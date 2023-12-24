package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.jtcommon.BcdUtils;
import info.gratour.jtcommon.JTUtils;
import io.netty.buffer.ByteBuf;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;

public class AdasAlmNo {

    private String deviceId;
    private String time;
    private int seqNum;
    private int attFileCount;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTime() {
        return time;
    }

    public long timeAsEpochSeconds() {
        return DateTimeUtils.BeijingConv.stringToSeconds(time);
    }

    public LocalDateTime timeAsLocalDateTime() {
        return DateTimeUtils.BeijingConv.strToLdt(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTime(long time) {
        this.time = DateTimeUtils.BeijingConv.millisToString(time);
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public int getAttFileCount() {
        return attFileCount;
    }

    public void setAttFileCount(int attFileCount) {
        this.attFileCount = attFileCount;
    }

    public static String bcdTime(byte[] bcd, int offset) {
        int y = 2000 + BcdUtils.decodeByte(bcd[offset]);
        int m = BcdUtils.decodeByte(bcd[offset + 1]);
        if (m < 0 || m > 12)
            return null;

        int d = BcdUtils.decodeByte(bcd[offset + 2]);
        if (d < 0 || d > 31)
            return null;

        int h = BcdUtils.decodeByte(bcd[offset + 3]);
        if (h < 0 || h > 23)
            return null;
        int min = BcdUtils.decodeByte(bcd[offset + 4]);
        if (min < 0 || min > 59)
            return null;
        int s = BcdUtils.decodeByte(bcd[offset + 5]);
        if (s < 0 || s > 60) //
            return null;

        StringBuilder str = new StringBuilder();
        str.append(y).append('-');
        if (m < 10)
            str.append('0');
        str.append(m).append('-');
        if (d < 10)
            str.append('0');
        str.append(d).append(' ');
        if (h < 10)
            str.append('0');
        str.append(h).append(':');
        if (min < 10)
            str.append('0');
        str.append(min).append(':');
        if (s < 10)
            str.append('0');
        str.append(s);

        return str.toString();
    }


    public static String bcdTime(byte[] bcd) {
        return bcdTime(bcd, 0);
    }

    public static void setBcdTime(LocalDateTime dateTime, byte[] bcd, int offset) {
        bcd[offset] = BcdUtils.encodeByte(dateTime.getYear() - 2000);
        bcd[offset + 1] = BcdUtils.encodeByte(dateTime.getMonthValue());
        bcd[offset + 2] = BcdUtils.encodeByte(dateTime.getDayOfMonth());
        bcd[offset + 3] = BcdUtils.encodeByte(dateTime.getHour());
        bcd[offset + 4] = BcdUtils.encodeByte(dateTime.getMinute());
        bcd[offset + 5] = BcdUtils.encodeByte(dateTime.getSecond());
    }

    public static byte[] newDecodeTempBuf() {
        return new byte[30];
    }

    public static final int ID_LEN_2013 = 16;
    public static final int ID_LEN_2019 = 40;

    public static AdasAlmNo decodeFrom_2013(byte[] buf) {
        AdasAlmNo r = new AdasAlmNo();
        r.setDeviceId(JTUtils.cStr(buf, 7));
        r.setTime(bcdTime(buf, 7));
        r.setSeqNum(buf[13] & 0xFF);
        r.setAttFileCount(buf[14] & 0xFF);

        return r;
    }

    public static AdasAlmNo decodeFrom_2013(ByteBuf buf, byte[] tempBuf) {
        AdasAlmNo r = new AdasAlmNo();
        buf.readBytes(tempBuf, 0, 7);

        r.setDeviceId(JTUtils.cStr(tempBuf, 7));
        buf.readBytes(tempBuf, 0, 6);
        r.setTime(bcdTime(tempBuf));
        if (r.getTime() == null)
            return null;

        r.setSeqNum(buf.readUnsignedByte());
        r.setAttFileCount(buf.readUnsignedByte());
        buf.skipBytes(1);

        return r;
    }

    public static int almNoLen(byte protoVer) {
        if (protoVer > 0)
            return 30 + 6 + 1 + 1 + 2;
        else
            return 7 + 6 + 1 + 1 + 1;
    }

    public void encode(byte protoVer, byte[] out, int offset) {
        int devIdLen;
        if (protoVer > 0)
            devIdLen = 30;
        else
            devIdLen = 7;

        byte[] bytes = deviceId.getBytes(StandardCharsets.US_ASCII);
        int copyLen = Math.min(bytes.length, devIdLen);

        System.arraycopy(bytes, 0, out, offset, copyLen);
        if (copyLen < devIdLen) {
            // fill remains to zero
            for (int i = 0; i < devIdLen - copyLen; i++) {
                out[offset + copyLen + i] = 0;
            }
        }

        LocalDateTime ldt = timeAsLocalDateTime();
        setBcdTime(ldt, out, offset + devIdLen);

        out[offset + devIdLen + 6] = (byte) seqNum;
        out[offset + devIdLen + 6 + 1] = (byte) attFileCount;
        out[offset + devIdLen + 6 + 2] = 0;
        if (protoVer > 0)
            out[offset + devIdLen + 6 + 3] = 0;
    }

    public byte[] encodeToBytes(byte protoVer) {
        int len = almNoLen(protoVer);
        byte[] r = new byte[len];
        encode(protoVer, r, 0);
        return r;
    }

    public String encodeToHex(byte protoVer) {
        return Hex.encodeHexString(encodeToBytes(protoVer));
    }

    public static AdasAlmNo decodeFrom_2019(byte[] buf) {
        AdasAlmNo r = new AdasAlmNo();

        r.setDeviceId(JTUtils.cStr(buf, 30));
        r.setTime(bcdTime(buf, 30));
        if (r.getTime() == null)
            return null;

        r.setSeqNum(buf[36] & 0xFF);
        r.setAttFileCount(buf[37] & 0xFF);

        return r;
    }

    public static AdasAlmNo decodeFrom_2019(ByteBuf buf, byte[] tempBuf) {
        AdasAlmNo r = new AdasAlmNo();
        buf.readBytes(tempBuf, 0, 30);

        r.setDeviceId(JTUtils.cStr(tempBuf, 30));
        buf.readBytes(tempBuf, 0, 6);
        r.setTime(bcdTime(tempBuf));
        r.setSeqNum(buf.readUnsignedByte());
        r.setAttFileCount(buf.readUnsignedByte());
        buf.skipBytes(2);

        return r;
    }

    public static AdasAlmNo decodeFrom(byte[] buf) {
        if (buf.length == ID_LEN_2013)
            return decodeFrom_2013(buf);
        else
            return decodeFrom_2019(buf);
    }

    public static AdasAlmNo decodeFromHex(String hex) {
        return decodeFrom(JTUtils.hex(hex));
    }

    @Override
    public String toString() {
        return "AdasStructuredAlmNo{" +
                "deviceId='" + deviceId + '\'' +
                ", time='" + time + '\'' +
                ", seqNum=" + seqNum +
                ", attFileCount=" + attFileCount +
                '}';
    }
}
