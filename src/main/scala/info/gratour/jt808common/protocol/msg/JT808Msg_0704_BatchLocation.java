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
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.BATCH_LOCATION_0704)
public class JT808Msg_0704_BatchLocation extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.BATCH_LOCATION_0704;

    public JT808Msg_0704_BatchLocation() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0704_BatchLocation(JT808FrameHeader header) {
        super(header);
    }

    private boolean retransmit;
    private Trk[] trks;

    public boolean isRetransmit() {
        return retransmit;
    }

    public void setRetransmit(boolean retransmit) {
        this.retransmit = retransmit;
    }

    public Trk[] getTrks() {
        return trks;
    }

    public void setTrks(Trk[] trks) {
        this.trks = trks;
    }

    @Override
    public String toString() {
        return "JT808Msg_0704_BatchLocation{" +
                "retransmit=" + retransmit +
                ", trks=" + Arrays.toString(trks) +
                "} " + super.toString();
    }
}
