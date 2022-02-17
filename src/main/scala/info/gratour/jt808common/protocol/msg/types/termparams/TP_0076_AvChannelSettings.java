/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

import java.util.Arrays;
import java.util.StringJoiner;

public class TP_0076_AvChannelSettings {

    public static class ChannelSetting {
        private byte phyChannelId;
        private byte logChannelId;
        private byte typ;
        private byte ptz;

        public byte getPhyChannelId() {
            return phyChannelId;
        }

        public void setPhyChannelId(byte phyChannelId) {
            this.phyChannelId = phyChannelId;
        }

        public byte getLogChannelId() {
            return logChannelId;
        }

        public void setLogChannelId(byte logChannelId) {
            this.logChannelId = logChannelId;
        }

        public byte getTyp() {
            return typ;
        }

        public void setTyp(byte typ) {
            this.typ = typ;
        }

        public byte getPtz() {
            return ptz;
        }

        public void setPtz(byte ptz) {
            this.ptz = ptz;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", ChannelSetting.class.getSimpleName() + "[", "]")
                    .add("phyChannelId=" + phyChannelId)
                    .add("logChannelId=" + logChannelId)
                    .add("typ=" + typ)
                    .add("ptz=" + ptz)
                    .toString();
        }
    }

    private byte avChannelCnt;
    private byte audioChannelCnt;
    private byte videoChannelCnt;
    private ChannelSetting[] channelSettings;

    public byte getAvChannelCnt() {
        return avChannelCnt;
    }

    public void setAvChannelCnt(byte avChannelCnt) {
        this.avChannelCnt = avChannelCnt;
    }

    public byte getAudioChannelCnt() {
        return audioChannelCnt;
    }

    public void setAudioChannelCnt(byte audioChannelCnt) {
        this.audioChannelCnt = audioChannelCnt;
    }

    public byte getVideoChannelCnt() {
        return videoChannelCnt;
    }

    public void setVideoChannelCnt(byte videoChannelCnt) {
        this.videoChannelCnt = videoChannelCnt;
    }

    public ChannelSetting[] getChannelSettings() {
        return channelSettings;
    }

    public void setChannelSettings(ChannelSetting[] channelSettings) {
        this.channelSettings = channelSettings;
    }

    @Override
    public String toString() {
        return "TP_0076_AVChannelSettings{" +
                "avChannelCnt=" + avChannelCnt +
                ", audioChannelCnt=" + audioChannelCnt +
                ", videoChannelCnt=" + videoChannelCnt +
                ", channelSettings=" + Arrays.toString(channelSettings) +
                '}';
    }
}
