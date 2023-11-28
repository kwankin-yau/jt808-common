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

@JTMsgId(JT1078MsgConsts.LIVE_AV_CTRL_9102)
public class CP_9102_LiveAvCtrl implements JT808CmdParams {

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


    private byte chan;
    private byte ctrl;
    private Byte closeAction;
    private Byte codeStrm;
    private String serverId;
    /**
     * only for client debug
     */
    private String closeReason;


    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
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

    public Byte getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(Byte codeStrm) {
        this.codeStrm = codeStrm;
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

    public int chan() {
        return chan;
    }

    public void chan(int value) {
        this.chan = (byte) value;
    }

    public int ctrl() {
        return ctrl;
    }

    public void ctrl(int value) {
        this.ctrl = (byte) value;
    }

    public int closeActionDef() {
        if (closeAction != null)
            return closeAction;
        else
            return CLOSE_ACTION__CLOSE_AV;
    }

    public void closeAction(int value) {
        this.closeAction = (byte) value;
    }

    public int codeStrmDef() {
        if (codeStrm != null)
            return codeStrm;
        else
            return CODE_STREAM__PRIMARY;
    }

    public void codeStrm(int value) {
        this.codeStrm = (byte) value;
    }

    public String serverId() {
        return serverId;
    }

    public void serverId(String value) {
        this.serverId = value;
    }

    public String closeReason() {
        return closeReason;
    }

    public void closeReason(String value) {
        this.closeReason = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9102_LiveAvCtrl.class.getSimpleName() + "[", "]")
                .add("chan=" + chan)
                .add("ctrl=" + ctrl)
                .add("closeAction=" + closeAction)
                .add("codeStrm=" + codeStrm)
                .add("serverId='" + serverId + "'")
                .add("closeReason='" + closeReason + "'")
                .toString();
    }

    @Override
    public CP_9102_LiveAvCtrl clone() {
        try {
            return (CP_9102_LiveAvCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
