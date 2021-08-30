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
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.LOCATION_0200)
public class JT808Msg_0200_Location extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.LOCATION_0200;

    public JT808Msg_0200_Location() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0200_Location(JT808FrameHeader header) {
        super(header);
    }

    private Trk trk;

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808Msg_0200_Location{" +
                "trk=" + trk +
                "} " + super.toString();
    }
}
