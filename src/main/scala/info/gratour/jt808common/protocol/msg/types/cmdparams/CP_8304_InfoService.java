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

@JTMsgId(JT808MsgConsts.INFO_SERVICE_8304)
public class CP_8304_InfoService implements JT808CmdParams {

    private byte infoType;
    private String info;

    public byte getInfoType() {
        return infoType;
    }

    public void setInfoType(byte infoType) {
        this.infoType = infoType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CP_8304_InfoService{" +
                "infoType=" + infoType +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public CP_8304_InfoService clone() {
        try {
            return (CP_8304_InfoService) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
