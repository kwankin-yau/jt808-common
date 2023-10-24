package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_0801)
public class JT808Msg_0801_MultiMediaData_Simplified extends JT808Msg {
    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_DATA_0801;

    public JT808Msg_0801_MultiMediaData_Simplified() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0801_MultiMediaData_Simplified(JT808FrameHeader header) {
        super(header);
    }

    private long mediaId;

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0801_MultiMediaData_Simplified.class.getSimpleName() + "[", "]")
                .add("mediaId=" + mediaId)
                .toString();
    }
}
