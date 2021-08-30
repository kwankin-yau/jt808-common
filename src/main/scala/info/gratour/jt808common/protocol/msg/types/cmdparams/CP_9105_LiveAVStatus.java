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

@JTMsgId(JT1078MsgConsts.LIVE_AV_STATUS_9105)
public class CP_9105_LiveAVStatus implements JT808CmdParams {

    private byte channelId;
    private byte lossRate;

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public byte getLossRate() {
        return lossRate;
    }

    public void setLossRate(byte lossRate) {
        this.lossRate = lossRate;
    }

    @Override
    public String toString() {
        return "CP_9105_LiveAVStatus{" +
                "channelId=" + channelId +
                ", lossRate=" + lossRate +
                '}';
    }

    @Override
    public CP_9105_LiveAVStatus clone() {
        try {
            return (CP_9105_LiveAVStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
