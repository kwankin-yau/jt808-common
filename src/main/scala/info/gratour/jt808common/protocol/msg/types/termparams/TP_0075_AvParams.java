/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.StringJoiner;

public class TP_0075_AvParams {

    private byte liveStreamMode;
    private byte liveStreamResolution;
    private int liveStreamKFrameInterval;
    private byte liveStreamFrameRate;
    private int liveStreamBitRate;

    private byte vodStreamMode;
    private byte vodStreamResolution;
    private int vodStreamKFrameInterval;
    private byte vodStreamFrameRate;
    private int vodStreamBitRate;

    private short osdSettings;
    private boolean audioOutEnabled;

    public byte getLiveStreamMode() {
        return liveStreamMode;
    }

    public void setLiveStreamMode(byte liveStreamMode) {
        this.liveStreamMode = liveStreamMode;
    }

    public byte getLiveStreamResolution() {
        return liveStreamResolution;
    }

    public void setLiveStreamResolution(byte liveStreamResolution) {
        this.liveStreamResolution = liveStreamResolution;
    }

    public int getLiveStreamKFrameInterval() {
        return liveStreamKFrameInterval;
    }

    public void setLiveStreamKFrameInterval(int liveStreamKFrameInterval) {
        this.liveStreamKFrameInterval = liveStreamKFrameInterval;
    }

    public byte getLiveStreamFrameRate() {
        return liveStreamFrameRate;
    }

    public void setLiveStreamFrameRate(byte liveStreamFrameRate) {
        this.liveStreamFrameRate = liveStreamFrameRate;
    }

    public int getLiveStreamBitRate() {
        return liveStreamBitRate;
    }

    public void setLiveStreamBitRate(int liveStreamBitRate) {
        this.liveStreamBitRate = liveStreamBitRate;
    }

    public byte getVodStreamMode() {
        return vodStreamMode;
    }

    public void setVodStreamMode(byte vodStreamMode) {
        this.vodStreamMode = vodStreamMode;
    }

    public byte getVodStreamResolution() {
        return vodStreamResolution;
    }

    public void setVodStreamResolution(byte vodStreamResolution) {
        this.vodStreamResolution = vodStreamResolution;
    }

    public int getVodStreamKFrameInterval() {
        return vodStreamKFrameInterval;
    }

    public void setVodStreamKFrameInterval(int vodStreamKFrameInterval) {
        this.vodStreamKFrameInterval = vodStreamKFrameInterval;
    }

    public byte getVodStreamFrameRate() {
        return vodStreamFrameRate;
    }

    public void setVodStreamFrameRate(byte vodStreamFrameRate) {
        this.vodStreamFrameRate = vodStreamFrameRate;
    }

    public int getVodStreamBitRate() {
        return vodStreamBitRate;
    }

    public void setVodStreamBitRate(int vodStreamBitRate) {
        this.vodStreamBitRate = vodStreamBitRate;
    }

    public short getOsdSettings() {
        return osdSettings;
    }

    public void setOsdSettings(short osdSettings) {
        this.osdSettings = osdSettings;
    }

    public boolean getAudioOutEnabled() {
        return audioOutEnabled;
    }

    public void setAudioOutEnabled(boolean audioOutEnabled) {
        this.audioOutEnabled = audioOutEnabled;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TP_0075_AvParams.class.getSimpleName() + "[", "]")
                .add("liveStreamMode=" + liveStreamMode)
                .add("liveStreamResolution=" + liveStreamResolution)
                .add("liveStreamKFrameInterval=" + liveStreamKFrameInterval)
                .add("liveStreamFrameRate=" + liveStreamFrameRate)
                .add("liveStreamBitRate=" + liveStreamBitRate)
                .add("vodStreamMode=" + vodStreamMode)
                .add("vodStreamResolution=" + vodStreamResolution)
                .add("vodStreamKFrameInterval=" + vodStreamKFrameInterval)
                .add("vodStreamFrameRate=" + vodStreamFrameRate)
                .add("vodStreamBitRate=" + vodStreamBitRate)
                .add("osdSettings=" + osdSettings)
                .add("audioOutEnabled=" + audioOutEnabled)
                .toString();
    }
}
