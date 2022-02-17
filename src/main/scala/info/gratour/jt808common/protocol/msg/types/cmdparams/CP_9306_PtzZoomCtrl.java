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

@JTMsgId(JT1078MsgConsts.PTZ_ZOOM_CTRL_9306)
public class CP_9306_PtzZoomCtrl implements JT808CmdParams {

    private byte chan;
    private byte ctrl;


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

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9306_PtzZoomCtrl.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .toString();
    }

    @Override
    public CP_9306_PtzZoomCtrl clone() {
        try {
            return (CP_9306_PtzZoomCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
