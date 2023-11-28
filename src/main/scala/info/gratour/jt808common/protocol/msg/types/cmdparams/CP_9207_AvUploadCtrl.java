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

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_CTRL_9207)
public class CP_9207_AvUploadCtrl implements JT808CmdParams {

    public static final byte CTRL__PAUSE = 0;
    public static final byte CTRL__RESUME = 1;
    public static final byte CTRL__CANCEL = 2;

    /**
     * cmd id
     */
    private String id;
    private int origSeqNo;
    private byte ctrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrigSeqNo() {
        return origSeqNo;
    }


    public void setOrigSeqNo(int origSeqNo) {
        this.origSeqNo = origSeqNo;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }


    public String id() {
        return id;
    }

    public void id(String value) {
        this.id = value;
    }

    public int origSeqNo() {
        return origSeqNo;
    }

    public void origSeqNo(int value) {
        this.origSeqNo = value;
    }

    public int ctrl() {
        return ctrl;
    }

    public void ctrl(int value) {
        this.ctrl = (byte) value;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CP_9207_AvUploadCtrl.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("origSeqNo=" + origSeqNo)
                .add("ctrl=" + ctrl)
                .toString();
    }

    @Override
    public CP_9207_AvUploadCtrl clone() {
        try {
            return (CP_9207_AvUploadCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
