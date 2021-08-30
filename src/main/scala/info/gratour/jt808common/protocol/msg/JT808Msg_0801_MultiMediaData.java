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
import info.gratour.jt808common.protocol.msg.types.addt.MQEventAddt_0801_MultiMediaData;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_DATA_0801)
public class JT808Msg_0801_MultiMediaData extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_DATA_0801;

    public JT808Msg_0801_MultiMediaData() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0801_MultiMediaData(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0801_MultiMediaData data;

    public MQEventAddt_0801_MultiMediaData getData() {
        return data;
    }

    public void setData(MQEventAddt_0801_MultiMediaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808Msg_0801_MultiMediaData{" +
                "data=" + data +
                "} " + super.toString();
    }
}
