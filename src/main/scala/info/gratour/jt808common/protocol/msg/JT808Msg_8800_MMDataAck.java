/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_ACK_8800)
public class JT808Msg_8800_MMDataAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_DATA_ACK_8800;

    public JT808Msg_8800_MMDataAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8800_MMDataAck(JT808FrameHeader header) {
        super(header);
    }

    private int mediaId;
    private short[] retransmitPacketIds;

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public short[] getRetransmitPacketIds() {
        return retransmitPacketIds;
    }

    public void setRetransmitPacketIds(short[] retransmitPacketIds) {
        this.retransmitPacketIds = retransmitPacketIds;
    }

    @Override
    public String toString() {
        return "JT808Msg_8800_MMDataAck{" +
                "mediaId=" + mediaId +
                ", retransmitPacketIds=" + Arrays.toString(retransmitPacketIds) +
                "} " + super.toString();
    }
}
