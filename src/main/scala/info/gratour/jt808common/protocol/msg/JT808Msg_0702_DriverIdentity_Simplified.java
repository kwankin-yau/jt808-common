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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0702_DriverIdentity;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.DRIVER_IDENTITY_0702)
public class JT808Msg_0702_DriverIdentity_Simplified extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.DRIVER_IDENTITY_0702;

    public JT808Msg_0702_DriverIdentity_Simplified() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0702_DriverIdentity_Simplified(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0702_DriverIdentity_Simplified.class.getSimpleName() + "[", "]")
                .toString();
    }
}
