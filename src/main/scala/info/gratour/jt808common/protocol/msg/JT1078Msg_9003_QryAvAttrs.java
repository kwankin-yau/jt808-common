/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_9003)
public class JT1078Msg_9003_QryAvAttrs extends JT1078Msg {

    public static final int MSG_ID = JT1078MsgConsts.QRY_AV_ATTRS_9003;

    public JT1078Msg_9003_QryAvAttrs() {
        setMsgId(MSG_ID);
    }

    public JT1078Msg_9003_QryAvAttrs(JT808FrameHeader header) {
        super(header);
    }

    @Override
    public String toString() {
        return "JT1078Msg_9003_QryAvAttrs{} " + super.toString();
    }
}
