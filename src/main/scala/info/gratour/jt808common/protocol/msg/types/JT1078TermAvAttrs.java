package info.gratour.jt808common.protocol.msg.types;

import java.util.StringJoiner;

public class JT1078TermAvAttrs {

    private byte audioCodec;
    private byte audioChannels;
    private byte audioSampleRate;
    private byte audioBitsPerSample;
    private int audioFrameSize;
    private boolean supportAudioOut;
    private byte videoCodec;
    private byte maxAudioChannels;
    private byte maxVideoChannels;

    public byte getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(byte audioCodec) {
        this.audioCodec = audioCodec;
    }

    public byte getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(byte audioChannels) {
        this.audioChannels = audioChannels;
    }

    public byte getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(byte audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public byte getAudioBitsPerSample() {
        return audioBitsPerSample;
    }

    public void setAudioBitsPerSample(byte audioBitsPerSample) {
        this.audioBitsPerSample = audioBitsPerSample;
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

    public byte getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(byte videoCodec) {
        this.videoCodec = videoCodec;
    }

    public byte getMaxAudioChannels() {
        return maxAudioChannels;
    }

    public void setMaxAudioChannels(byte maxAudioChannels) {
        this.maxAudioChannels = maxAudioChannels;
    }

    public byte getMaxVideoChannels() {
        return maxVideoChannels;
    }

    public void setMaxVideoChannels(byte maxVideoChannels) {
        this.maxVideoChannels = maxVideoChannels;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078TermAvAttrs.class.getSimpleName() + "[", "]")
                .add("audioCodec=" + audioCodec)
                .add("audioChannels=" + audioChannels)
                .add("audioSampleRate=" + audioSampleRate)
                .add("audioBitsPerSample=" + audioBitsPerSample)
                .add("audioFrameSize=" + audioFrameSize)
                .add("supportAudioOut=" + supportAudioOut)
                .add("videoEnc=" + videoCodec)
                .add("maxAudioChannels=" + maxAudioChannels)
                .add("maxVideoChannels=" + maxVideoChannels)
                .toString();
    }

    public void assignFrom(JT1078TermAvAttrs source) {
        this.audioCodec = source.audioCodec;
        this.audioChannels = source.audioChannels;
        this.audioSampleRate = source.audioSampleRate;
        this.audioBitsPerSample = source.audioBitsPerSample;
        this.audioFrameSize = source.audioFrameSize;
        this.supportAudioOut = source.supportAudioOut;
        this.videoCodec = source.videoCodec;
        this.maxAudioChannels = source.maxAudioChannels;
        this.maxVideoChannels = source.maxVideoChannels;
    }

    @Override
    public JT1078TermAvAttrs clone() {
        JT1078TermAvAttrs r = new JT1078TermAvAttrs();
        r.assignFrom(this);
        return r;
    }

}
