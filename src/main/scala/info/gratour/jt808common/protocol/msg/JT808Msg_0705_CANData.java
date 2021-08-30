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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0705_CANData;
import info.gratour.jtcommon.JTMsgId;

import java.time.LocalTime;

@JTMsgId(JT808MsgConsts.CAN_DATA_0705)
public class JT808Msg_0705_CANData extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.CAN_DATA_0705;

    public JT808Msg_0705_CANData() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0705_CANData(JT808FrameHeader header) {
        super(header);
    }

    private LocalTime receiveTime;
    private MQEventAddt_0705_CANData canData;

    public LocalTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public MQEventAddt_0705_CANData getCanData() {
        return canData;
    }

    public void setCanData(MQEventAddt_0705_CANData canData) {
        this.canData = canData;
    }

    @Override
    public String toString() {
        return "JT808Msg_0705_CANData{" +
                "receiveTime=" + receiveTime +
                ", canData=" + canData +
                "} " + super.toString();
    }
}
