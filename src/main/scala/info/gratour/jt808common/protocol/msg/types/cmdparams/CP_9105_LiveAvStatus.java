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

@JTMsgId(JT1078MsgConsts.LIVE_AV_STATUS_9105)
public class CP_9105_LiveAvStatus implements JT808CmdParams {

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

    public int chan() {
        return channelId;
    }

    public void chan(int value) {
        this.channelId = (byte) value;
    }

    public int lossRate() {
        return lossRate;
    }

    public void lossRate(int value) {
        this.lossRate = (byte) value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9105_LiveAvStatus.class.getSimpleName() + "[", "]")
                .add("channelId=" + channelId)
                .add("lossRate=" + lossRate)
                .toString();
    }

    @Override
    public CP_9105_LiveAvStatus clone() {
        try {
            return (CP_9105_LiveAvStatus) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
