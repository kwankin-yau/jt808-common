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

@JTMsgId(JT808MsgConsts.AUDIO_RECORD_CTRL_8804)
public class CP_8804_AudioRecordCtrl implements JT808CmdParams {

    private byte action;
    private int recordTime;
    private byte saveFlag;
    private byte sampleFrequency;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public int getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(int recordTime) {
        this.recordTime = recordTime;
    }

    public byte getSaveFlag() {
        return saveFlag;
    }

    public void setSaveFlag(byte saveFlag) {
        this.saveFlag = saveFlag;
    }

    public byte getSampleFrequency() {
        return sampleFrequency;
    }

    public void setSampleFrequency(byte sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    @Override
    public String toString() {
        return "CP_8804_AudioRecordCtrl{" +
                "action=" + action +
                ", recordTime=" + recordTime +
                ", saveFlag=" + saveFlag +
                ", sampleFrequency=" + sampleFrequency +
                '}';
    }

    @Override
    public CP_8804_AudioRecordCtrl clone() {
        try {
            return (CP_8804_AudioRecordCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
