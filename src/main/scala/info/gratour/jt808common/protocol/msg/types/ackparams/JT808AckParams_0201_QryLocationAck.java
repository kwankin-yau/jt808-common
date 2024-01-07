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


@JTMsgId(JT808MsgConsts.QRY_LOCATION_ACK_0201)
public class JT808AckParams_0201_QryLocationAck implements JT808AckParams, Cloneable {

    private Trk trk;

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0201_QryLocationAck{" +
                "trk=" + trk +
                '}';
    }

    @Override
    public JT808AckParams_0201_QryLocationAck clone() {
        try {
            return (JT808AckParams_0201_QryLocationAck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
