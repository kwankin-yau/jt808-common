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

@JTMsgId(JT808MsgConsts.SINGLE_STORED_MEDIA_REQ_8805)
public class CP_8805_SingleStoredMediaReq implements JT808CmdParams {

    private int mediaId;
    private byte deleteFlag;

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "CP_8805_SingleStoredMediaReq{" +
                "mediaId=" + mediaId +
                ", deleteFlag=" + deleteFlag +
                '}';
    }

    @Override
    public CP_8805_SingleStoredMediaReq clone() {
        try {
            return (CP_8805_SingleStoredMediaReq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
