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
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8700_VtdrDataCollectReq;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
public class JT808Msg_8700_VtdrDataCollectReq extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700;

    public JT808Msg_8700_VtdrDataCollectReq() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8700_VtdrDataCollectReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_8700_VtdrDataCollectReq params;

    public CP_8700_VtdrDataCollectReq getParams() {
        return params;
    }

    public void setParams(CP_8700_VtdrDataCollectReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_8700_VtdrDataCollectReq.class.getSimpleName() + "[", "]")
                .add("params=" + params)
                .toString();
    }
}
