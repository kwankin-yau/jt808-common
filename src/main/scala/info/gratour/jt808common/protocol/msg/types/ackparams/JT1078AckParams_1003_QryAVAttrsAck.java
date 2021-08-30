/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003)
public class JT1078AckParams_1003_QryAVAttrsAck implements JT808AckParams {

    private byte inputAudioEnc;
    private byte inputAudioChannel;
    private byte inputAudioFrequency;
    private byte inputAudioBits;
    private int audioFrameSize;
    private boolean supportAudioOut;
    private byte videoEnc;
    private byte maxAudioChannel;
    private byte maxVideoChannel;

    public byte getInputAudioEnc() {
        return inputAudioEnc;
    }

    public void setInputAudioEnc(byte inputAudioEnc) {
        this.inputAudioEnc = inputAudioEnc;
    }

    public byte getInputAudioChannel() {
        return inputAudioChannel;
    }

    public void setInputAudioChannel(byte inputAudioChannel) {
        this.inputAudioChannel = inputAudioChannel;
    }

    public byte getInputAudioFrequency() {
        return inputAudioFrequency;
    }

    public void setInputAudioFrequency(byte inputAudioFrequency) {
        this.inputAudioFrequency = inputAudioFrequency;
    }

    public byte getInputAudioBits() {
        return inputAudioBits;
    }

    public void setInputAudioBits(byte inputAudioBits) {
        this.inputAudioBits = inputAudioBits;
    }

    public int getAudioFrameSize() {
        return audioFrameSize;
    }

    public void setAudioFrameSize(int audioFrameSize) {
        this.audioFrameSize = audioFrameSize;
    }

    public boolean isSupportAudioOut() {
        return supportAudioOut;
    }

    public void setSupportAudioOut(boolean supportAudioOut) {
        this.supportAudioOut = supportAudioOut;
    }

    public byte getVideoEnc() {
        return videoEnc;
    }

    public void setVideoEnc(byte videoEnc) {
        this.videoEnc = videoEnc;
    }

    public byte getMaxAudioChannel() {
        return maxAudioChannel;
    }

    public void setMaxAudioChannel(byte maxAudioChannel) {
        this.maxAudioChannel = maxAudioChannel;
    }

    public byte getMaxVideoChannel() {
        return maxVideoChannel;
    }

    public void setMaxVideoChannel(byte maxVideoChannel) {
        this.maxVideoChannel = maxVideoChannel;
    }

    @Override
    public String toString() {
        return "JT1078AckParams_1003_QryAVAttrsAck{" +
                "inputAudioEnc=" + inputAudioEnc +
                ", inputAudioChannel=" + inputAudioChannel +
                ", inputAudioSamplingFrequency=" + inputAudioFrequency +
                ", inputAudioSamplingBits=" + inputAudioBits +
                ", audioFrameSize=" + audioFrameSize +
                ", supportAudioOutput=" + supportAudioOut +
                ", videoEnc=" + videoEnc +
                ", maxAudioChannel=" + maxAudioChannel +
                ", maxVideoChannel=" + maxVideoChannel +
                '}';
    }

    public void assignFrom(JT1078AckParams_1003_QryAVAttrsAck source) {
        this.inputAudioEnc = source.inputAudioEnc;
        this.inputAudioChannel = source.inputAudioChannel;
        this.inputAudioFrequency = source.inputAudioFrequency;
        this.inputAudioBits = source.inputAudioBits;
        this.audioFrameSize = source.audioFrameSize;
        this.supportAudioOut = source.supportAudioOut;
        this.videoEnc = source.videoEnc;
        this.maxAudioChannel = source.maxAudioChannel;
        this.maxVideoChannel = source.maxVideoChannel;
    }

    @Override
    public JT1078AckParams_1003_QryAVAttrsAck clone() {
        JT1078AckParams_1003_QryAVAttrsAck r = new JT1078AckParams_1003_QryAVAttrsAck();
        r.assignFrom(this);
        return r;
    }
}
