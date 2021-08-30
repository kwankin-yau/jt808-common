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

@JTMsgId(JT808MsgConsts.PHONE_CALLBACK_8400)
public class CP_8400_PhoneCallback implements JT808CmdParams {

    public static final int ACTION__TALK = 0;
    public static final int ACTION__LISTEN = 1;

    private byte action;
    private String phoneNo;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "CP_8400_PhoneCallback{" +
                "action=" + action +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public CP_8400_PhoneCallback clone() {
        try {
            return (CP_8400_PhoneCallback) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
