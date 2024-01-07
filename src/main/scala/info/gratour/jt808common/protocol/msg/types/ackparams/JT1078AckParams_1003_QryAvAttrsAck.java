/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT1078MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT1078TermAvAttrs;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT1078MsgConsts.QRY_AV_ATTRS_ACK_1003)
public class JT1078AckParams_1003_QryAvAttrsAck extends JT1078TermAvAttrs implements JT808AckParams, Cloneable {


    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AckParams_1003_QryAvAttrsAck.class.getSimpleName() + "[", "]")
                .add("inputAudioEnc=" + getAudioCodec())
                .add("inputAudioChannel=" + getAudioChannels())
                .add("inputAudioFrequency=" + getAudioSampleRate())
                .add("inputAudioBits=" + getAudioBitsPerSample())
                .add("audioFrameSize=" + getAudioFrameSize())
                .add("supportAudioOut=" + isSupportAudioOut())
                .add("videoEnc=" + getVideoCodec())
                .add("maxAudioChannel=" + getMaxAudioChannels())
                .add("maxVideoChannel=" + getMaxVideoChannels())
                .toString();
    }

    @Override
    public JT1078AckParams_1003_QryAvAttrsAck clone() {
        JT1078AckParams_1003_QryAvAttrsAck r = new JT1078AckParams_1003_QryAvAttrsAck();
        r.assignFrom(this);
        return r;
    }
}
