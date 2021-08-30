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

@JTMsgId(JT808MsgConsts.PASS_THROUGH_DATA_DL_8900)
public class JT808Msg_8900_PassThroughDL extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.PASS_THROUGH_DATA_DL_8900;

    public JT808Msg_8900_PassThroughDL() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8900_PassThroughDL(JT808FrameHeader header) {
        super(header);
    }

    private byte typ;
    private byte[] content;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JT808Msg_PassThroughDL_8900{" +
                "typ=" + typ +
                "} " + super.toString();
    }
}
