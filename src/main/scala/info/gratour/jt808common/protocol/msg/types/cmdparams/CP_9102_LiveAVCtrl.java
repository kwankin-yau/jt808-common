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

@JTMsgId(JT1078MsgConsts.LIVE_AV_CTRL_9102)
public class CP_9102_LiveAVCtrl implements JT808CmdParams {

    public static final int CTRL__CLOSE_CHANNEL = 0;
    public static final int CTRL__SWITCH_CODE_STREAM = 1;
    public static final int CTRL__PAUSE = 2;
    public static final int CTRL__RESUME = 3;
    public static final int CTRL__CLOSE_TALK = 4;

    public static final byte CLOSE_ACTION__CLOSE_AV = 0;
    public static final byte CLOSE_ACTION__CLOSE_V = 1;
    public static final byte CLOSE_ACTION__CLOSE_A = 2;

    public static final byte CODE_STREAM__PRIMARY = 0;
    public static final byte CODE_STREAM__SUBORDINATE = 1;


    private byte channel;
    private byte ctrl;
    private Byte closeAction;
    private Byte codeStream;
    private String serverId;
    /**
     * only for client debug
     */
    private String closeReason;


    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(int ctrl) {
        this.ctrl = (byte) ctrl;
    }

    public Byte getCloseAction() {
        return closeAction;
    }

    public void setCloseAction(Byte closeAction) {
        this.closeAction = closeAction;
    }

    public Byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(Byte codeStream) {
        this.codeStream = codeStream;
    }



    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Override
    public String toString() {
        return "CP_9102_LiveAVCtrl{" +
                "channel=" + channel +
                ", ctrl=" + ctrl +
                ", closeAction=" + closeAction +
                ", codeStream=" + codeStream +
                ", serverId='" + serverId + '\'' +
                ", closeReason='" + closeReason + '\'' +
                '}';
    }

    @Override
    public CP_9102_LiveAVCtrl clone() {
        try {
            return (CP_9102_LiveAVCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
