/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808MediaInfo;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.STORED_MEDIA_SEARCH_ACK_0802)
public class JT808AckParams_0802_StoredMediaSearchAck implements JT808AckParams, Cloneable {

    private JT808MediaInfo[] mediaInfos;

    public JT808MediaInfo[] getMediaInfos() {
        return mediaInfos;
    }

    public void setMediaInfos(JT808MediaInfo[] mediaInfos) {
        this.mediaInfos = mediaInfos;
    }

    public void assignFrom(JT808AckParams_0802_StoredMediaSearchAck source) {
        if (source.mediaInfos != null) {
            this.mediaInfos = new JT808MediaInfo[source.mediaInfos.length];
            for (int i = 0; i < this.mediaInfos.length; i++) {
                this.mediaInfos[i] = source.mediaInfos[i].clone();
            }
        } else
            this.mediaInfos = null;
    }

    @Override
    public JT808AckParams_0802_StoredMediaSearchAck clone() {
        JT808AckParams_0802_StoredMediaSearchAck r = new JT808AckParams_0802_StoredMediaSearchAck();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0802_StoredMediaSearchAck{" +
                "mediaInfos=" + Arrays.toString(mediaInfos) +
                '}';
    }
}
