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

@JTMsgId(JT1078MsgConsts.PTZ_TURN_9301)
public class CP_9301_PTZTurn implements JT808CmdParams {

    private byte channelId;
    private byte direction;
    private byte speed;

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public byte getDirection() {
        return direction;
    }

    public void setDirection(byte direction) {
        this.direction = direction;
    }

    public byte getSpeed() {
        return speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "CP_9301_PTZTurn{" +
                "channelId=" + channelId +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }

    @Override
    public CP_9301_PTZTurn clone() {
        try {
            return (CP_9301_PTZTurn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
