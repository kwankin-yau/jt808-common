package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;
import info.gratour.jt808common.AdasDialect;
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt;

import java.lang.reflect.Type;
import java.util.StringJoiner;

public class Event {

    public static final Type TYPE = new TypeToken<Event>(){}.getType();

    public static final String MSG_ID__ONLINE = "ONLINE";
    public static final String MSG_ID__OFFLINE = "OFFLINE";

    private String msgId;
    private String simNo;
    private long recvTm;
    private String adasDialect;
    private String protoVer;
    private MQEventAddt addt;

    /**
     * jt808/jt1078 message id or `ONLINE` or `OFFLINE`
     *
     * @return message id of the event
     */
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    /**
     * String value of {@link info.gratour.jt808common.AdasDialect}. Indicates the event is received from
     * the `JT/T 808` end point with the adasDialect.
     *
     * @return adasDialect using by the `JT/T 808` end point.
     */
    public String getAdasDialect() {
        return adasDialect;
    }

    public void setAdasDialect(String adasDialect) {
        this.adasDialect = adasDialect;
    }

    public AdasDialect adasDialect() {
        return AdasDialect.valueOf(adasDialect);
    }

    /**
     * 协议版本号。对于JT808 协议，0 为 2011/2013版, 1 为 2019版.
     *
     * @return 协议版本号
     */
    public String getProtoVer() {
        return protoVer;
    }

    public void setProtoVer(String protoVer) {
        this.protoVer = protoVer;
    }

    public MQEventAddt getAddt() {
        return addt;
    }

    public void setAddt(MQEventAddt addt) {
        this.addt = addt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Event.class.getSimpleName() + "[", "]")
                .add("msgId='" + msgId + "'")
                .add("simNo='" + simNo + "'")
                .add("recvTm=" + recvTm)
                .add("adasDialect='" + adasDialect + "'")
                .add("protoVer='" + protoVer + "'")
                .add("addt=" + addt)
                .toString();
    }
}
