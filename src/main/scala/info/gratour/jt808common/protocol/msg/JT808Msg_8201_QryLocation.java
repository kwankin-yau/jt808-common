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

@JTMsgId(JT808MsgConsts.QRY_LOCATION_8201)
public class JT808Msg_8201_QryLocation extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.QRY_LOCATION_8201;

    public JT808Msg_8201_QryLocation() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8201_QryLocation(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT808Msg_8201_QryLocation{} " + super.toString();
    }
}
