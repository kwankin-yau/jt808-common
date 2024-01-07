/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.trk.Trk;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.VEH_CTRL_ACK_0500)
public class JT808AckParams_0500_VehCtrlAck implements JT808AckParams, Cloneable {

    private Trk trk;

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0500_VehCtrlAck{" +
                "trk=" + trk +
                '}';
    }

    public void assinFrom(JT808AckParams_0500_VehCtrlAck source) {
        this.trk = source.trk != null ? source.trk.clone() : null;
    }

    @Override
    public JT808AckParams_0500_VehCtrlAck clone() {
        JT808AckParams_0500_VehCtrlAck r = new JT808AckParams_0500_VehCtrlAck();
        r.assinFrom(this);
        return r;
    }
}
