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

@JTMsgId(JT1078MsgConsts.PTZ_ZOOM_CTRL_9306)
public class CP_9306_PTZZoomCtrl implements JT808CmdParams {

    private byte channelId;
    private byte ctrl;


    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public String toString() {
        return "CP_9306_PTZZoomCtrl{" +
                "channelId=" + channelId +
                ", ctrl=" + ctrl +
                '}';
    }

    @Override
    public CP_9306_PTZZoomCtrl clone() {
        try {
            return (CP_9306_PTZZoomCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
