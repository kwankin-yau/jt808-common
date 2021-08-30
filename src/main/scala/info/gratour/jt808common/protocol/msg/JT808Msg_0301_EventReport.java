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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0301_EventReport;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.EVENT_REPORT_0301)
public class JT808Msg_0301_EventReport extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.EVENT_REPORT_0301;

    public JT808Msg_0301_EventReport() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0301_EventReport(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0301_EventReport info;

    public MQEventAddt_0301_EventReport getInfo() {
        return info;
    }

    public void setInfo(MQEventAddt_0301_EventReport info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "JT808Msg_0301_EventReport{" +
                "info=" + info +
                "} " + super.toString();
    }
}
