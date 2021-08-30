/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT1078AVRes;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT1078MsgConsts.QRY_AV_RES_ACK_1205)
public class JT1078AckParams_1205_QryAVResAck implements JT808AckParams {

    private JT1078AVRes[] resList;

    public JT1078AVRes[] getResList() {
        return resList;
    }

    public void setResList(JT1078AVRes[] resList) {
        this.resList = resList;
    }

    @Override
    public String toString() {
        return "JT1078AckParams_1205_QryAVResAck{" +
                "resList=" + Arrays.toString(resList) +
                '}';
    }

    public void assignFrom(JT1078AckParams_1205_QryAVResAck source) {
        if (source.resList != null) {
            resList = new JT1078AVRes[source.resList.length];
            for (int i = 0; i < source.resList.length; i++) {
                resList[i] = source.resList[i].clone();
            }
        } else
            resList = null;
    }

    @Override
    public JT1078AckParams_1205_QryAVResAck clone() {
        JT1078AckParams_1205_QryAVResAck r = new JT1078AckParams_1205_QryAVResAck();
        r.assignFrom(this);
        return r;
    }
}
