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
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0700_VTDRData;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.VTDR_DATA_0700)
public class JT808Msg_0700_VTDRData extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.VTDR_DATA_0700;

    public JT808Msg_0700_VTDRData() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0700_VTDRData(JT808FrameHeader header) {
        super(header);
    }

    private int ackSeqNo;
    private JT808AckParams_0700_VTDRData ackParams;

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public JT808AckParams_0700_VTDRData getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams_0700_VTDRData ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return "JT808Msg_0700_VTDRData{" +
                "ackSeqNo=" + ackSeqNo +
                ", ackParams=" + ackParams +
                "} " + super.toString();
    }
}
