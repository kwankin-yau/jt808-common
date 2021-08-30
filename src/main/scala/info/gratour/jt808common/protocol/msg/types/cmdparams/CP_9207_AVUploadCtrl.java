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

@JTMsgId(JT1078MsgConsts.AV_UPLOAD_CTRL_9207)
public class CP_9207_AVUploadCtrl implements JT808CmdParams {

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

    @Override
    public String toString() {
        return "CP_9207_AVUploadCtrl{" +
                "id='" + id + '\'' +
                ", origSeqNo=" + origSeqNo +
                ", ctrl=" + ctrl +
                '}';
    }

    @Override
    public CP_9207_AVUploadCtrl clone() {
        try {
            return (CP_9207_AVUploadCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
