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

@JTMsgId(JT808MsgConsts.TAKE_PHOTO_8801)
public class CP_8801_TakePhoto implements JT808CmdParams {

    private byte channel;
    private short cmd;
    private Short count;
    private Short interval;
    private Byte save;
    private Byte resolution;
    private Byte quality;
    private Byte brightness;
    private Byte contrast;
    private Byte saturability;
    private Byte chroma;

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public short getCmd() {
        return cmd;
    }

    public void setCmd(short cmd) {
        this.cmd = cmd;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    public Short getInterval() {
        return interval;
    }

    public void setInterval(Short interval) {
        this.interval = interval;
    }

    public Byte getSave() {
        return save;
    }

    public void setSave(Byte save) {
        this.save = save;
    }

    public Byte getResolution() {
        return resolution;
    }

    public void setResolution(Byte resolution) {
        this.resolution = resolution;
    }

    public Byte getQuality() {
        return quality;
    }

    public void setQuality(Byte quality) {
        this.quality = quality;
    }

    public Byte getBrightness() {
        return brightness;
    }

    public void setBrightness(Byte brightness) {
        this.brightness = brightness;
    }

    public Byte getContrast() {
        return contrast;
    }

    public void setContrast(Byte contrast) {
        this.contrast = contrast;
    }

    public Byte getSaturability() {
        return saturability;
    }

    public void setSaturability(Byte saturability) {
        this.saturability = saturability;
    }

    public Byte getChroma() {
        return chroma;
    }

    public void setChroma(Byte chroma) {
        this.chroma = chroma;
    }

    @Override
    public String toString() {
        return "CP_8801_TakePhoto{" +
                "channel=" + channel +
                ", cmd=" + cmd +
                ", count=" + count +
                ", interval=" + interval +
                ", save=" + save +
                ", resolution=" + resolution +
                ", quality=" + quality +
                ", brightness=" + brightness +
                ", contrast=" + contrast +
                ", saturability=" + saturability +
                ", chroma=" + chroma +
                '}';
    }

    @Override
    public CP_8801_TakePhoto clone() {
        try {
            return (CP_8801_TakePhoto) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
