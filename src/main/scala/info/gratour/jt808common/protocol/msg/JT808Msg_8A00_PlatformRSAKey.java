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

@JTMsgId(JT808MsgConsts.PLATFORM_RSA_KEY_8A00)
public class JT808Msg_8A00_PlatformRSAKey extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.PLATFORM_RSA_KEY_8A00;

    public JT808Msg_8A00_PlatformRSAKey() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8A00_PlatformRSAKey(JT808FrameHeader header) {
        super(header);
    }

    private long e;
    private byte[] n;

    public long getE() {
        return e;
    }

    public void setE(long e) {
        this.e = e;
    }

    public byte[] getN() {
        return n;
    }

    public void setN(byte[] n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "JT808Msg_8A00_PlatformRSAKey{} " + super.toString();
    }
}
