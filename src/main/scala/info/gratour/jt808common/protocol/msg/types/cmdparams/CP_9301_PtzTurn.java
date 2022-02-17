/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.PTZ_TURN_9301)
public class CP_9301_PtzTurn implements JT808CmdParams {

    private byte chan;
    private byte ctrl;
    private byte spd;

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    public byte getSpd() {
        return spd;
    }

    public void setSpd(byte spd) {
        this.spd = spd;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9301_PtzTurn.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .add("spd=" + spd)
                .toString();
    }

    @Override
    public CP_9301_PtzTurn clone() {
        try {
            return (CP_9301_PtzTurn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
