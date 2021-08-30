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

@JTMsgId(JT808MsgConsts.COMPRESSED_DATA_UL_0x0901)
public class JT808Msg_0901_CompressedDataUL extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.COMPRESSED_DATA_UL_0x0901;

    public JT808Msg_0901_CompressedDataUL() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0901_CompressedDataUL(JT808FrameHeader header) {
        super(header);
    }

    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808Msg_0901_CompressedDataUL{} " + super.toString();
    }
}
