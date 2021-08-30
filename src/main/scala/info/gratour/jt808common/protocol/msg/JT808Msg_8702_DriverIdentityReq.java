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

@JTMsgId(JT808MsgConsts.DRIVER_IDENTITY_REQ_8702)
public class JT808Msg_8702_DriverIdentityReq extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.DRIVER_IDENTITY_REQ_8702;

    public JT808Msg_8702_DriverIdentityReq() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8702_DriverIdentityReq(JT808FrameHeader header) {
        super(header);
    }



    @Override
    public String toString() {
        return "JT808Msg_8702_DriverIdentityReq{} " + super.toString();
    }
}
