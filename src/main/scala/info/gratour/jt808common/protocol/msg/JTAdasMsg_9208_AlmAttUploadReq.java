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
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9208_AlmAddtUploadReq;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208)
public class JTAdasMsg_9208_AlmAttUploadReq extends JT808Msg {

    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_UPLOAD_REQ_9208;

    public JTAdasMsg_9208_AlmAttUploadReq() {
        setMsgId(MSG_ID);
    }

    public JTAdasMsg_9208_AlmAttUploadReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_9208_AlmAddtUploadReq params;

    public CP_9208_AlmAddtUploadReq getParams() {
        return params;
    }

    public void setParams(CP_9208_AlmAddtUploadReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JTAdasMsg_9208_AlmAttUploadReq{" +
                "params=" + params +
                '}';
    }
}
