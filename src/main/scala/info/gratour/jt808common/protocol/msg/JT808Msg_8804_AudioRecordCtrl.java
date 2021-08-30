/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8804_AudioRecordCtrl;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.AUDIO_RECORD_CTRL_8804)
public class JT808Msg_8804_AudioRecordCtrl extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.AUDIO_RECORD_CTRL_8804;

    public JT808Msg_8804_AudioRecordCtrl() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8804_AudioRecordCtrl(JT808FrameHeader header) {
        super(header);
    }

    private CP_8804_AudioRecordCtrl params;

    public CP_8804_AudioRecordCtrl getParams() {
        return params;
    }

    public void setParams(CP_8804_AudioRecordCtrl params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8804_AudioRecordCtrl{" +
                "params=" + params +
                "} " + super.toString();
    }
}
