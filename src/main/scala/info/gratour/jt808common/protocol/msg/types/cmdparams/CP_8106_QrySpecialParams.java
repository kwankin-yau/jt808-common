/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.QRY_SPECIAL_PARAMS_8106)
public class CP_8106_QrySpecialParams implements JT808CmdParams {

    private String[] paramIds;

    public String[] getParamIds() {
        return paramIds;
    }

    public void setParamIds(String[] paramIds) {
        this.paramIds = paramIds;
    }

    @Override
    public String toString() {
        return "CP_8106_QrySpecialParams{" +
                "paramIds=" + Arrays.toString(paramIds) +
                '}';
    }

    @Override
    public CP_8106_QrySpecialParams clone() {
        try {
            return (CP_8106_QrySpecialParams) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
