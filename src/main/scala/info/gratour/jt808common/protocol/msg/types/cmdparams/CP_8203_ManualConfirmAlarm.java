/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.MANUAL_CONFIRM_ALARM_8203)
public class CP_8203_ManualConfirmAlarm implements JT808CmdParams {

    private int ackSeqNo;
    private int confirmAlarmTypes;
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public int getConfirmAlarmTypes() {
        return confirmAlarmTypes;
    }

    public void setConfirmAlarmTypes(int confirmAlarmTypes) {
        this.confirmAlarmTypes = confirmAlarmTypes;
    }

    @Override
    public String toString() {
        return "CP_8203_ManualConfirmAlarm{" +
                "ackSeqNo=" + ackSeqNo +
                ", confirmAlarmTypes=" + confirmAlarmTypes +
                '}';
    }

    @Override
    public CP_8203_ManualConfirmAlarm clone() {
        try {
            return (CP_8203_ManualConfirmAlarm) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
