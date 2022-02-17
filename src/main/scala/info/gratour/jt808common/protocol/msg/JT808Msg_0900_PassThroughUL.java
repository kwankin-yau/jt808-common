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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0900_PassThroughUl;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.PASS_THROUGH_DATA_UL_0900)
public class JT808Msg_0900_PassThroughUL extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.PASS_THROUGH_DATA_UL_0900;

    public JT808Msg_0900_PassThroughUL() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0900_PassThroughUL(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0900_PassThroughUl data;

    public MQEventAddt_0900_PassThroughUl getData() {
        return data;
    }

    public void setData(MQEventAddt_0900_PassThroughUl data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0900_PassThroughUL.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .toString();
    }
}
