/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.TAKE_PHOTO_ACK_0805)
public class JT808AckParams_0805_TakePhotoAck implements JT808AckParams, Cloneable {

    private byte result;
    private long[] mediaIds;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public long[] getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(long[] mediaIds) {
        this.mediaIds = mediaIds;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0805_TakePhotoAck{" +
                "result=" + result +
                ", mediaIds=" + Arrays.toString(mediaIds) +
                '}';
    }

    @Override
    public JT808AckParams_0805_TakePhotoAck clone() {
        try {
            return  (JT808AckParams_0805_TakePhotoAck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
