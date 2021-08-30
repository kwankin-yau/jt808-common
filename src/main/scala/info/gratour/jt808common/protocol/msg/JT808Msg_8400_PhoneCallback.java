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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8400_PhoneCallback;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.PHONE_CALLBACK_8400)
public class JT808Msg_8400_PhoneCallback extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.PHONE_CALLBACK_8400;

    public JT808Msg_8400_PhoneCallback() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8400_PhoneCallback(JT808FrameHeader header) {
        super(header);
    }

    private CP_8400_PhoneCallback params;

    public CP_8400_PhoneCallback getParams() {
        return params;
    }

    public void setParams(CP_8400_PhoneCallback params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8400_PhoneCallback{" +
                "params=" + params +
                "} " + super.toString();
    }
}
