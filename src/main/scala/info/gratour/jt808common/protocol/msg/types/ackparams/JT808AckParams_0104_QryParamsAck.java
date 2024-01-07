/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.HashMap;
import java.util.Map;

@JTMsgId(JT808MsgConsts.QRY_PARAMS_ACK_0104)
public class JT808AckParams_0104_QryParamsAck implements JT808AckParams, Cloneable {



    private Map<String, Object> params = new HashMap<>();

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0104_QryParamsAck{" +
                "params=" + params +
                '}';
    }

    public void assignFrom(JT808AckParams_0104_QryParamsAck source) {
        if (source.params != null) {
            this.params = new HashMap<>();
            this.params.putAll(source.params);
        } else
            this.params = null;
    }

    @Override
    public JT808AckParams_0104_QryParamsAck clone() {
        JT808AckParams_0104_QryParamsAck r = new JT808AckParams_0104_QryParamsAck();
        r.assignFrom(this);
        return r;
    }
}
