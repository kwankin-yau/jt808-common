package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8103_SetParams;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.SET_PARAMS_8103)
public class JT808Msg_8103_SetParam extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_PARAMS_8103;

    public JT808Msg_8103_SetParam() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8103_SetParam(JT808FrameHeader header) {
        super(header);
    }

    private CP_8103_SetParams params;

    public CP_8103_SetParams getParams() {
        return params;
    }

    public void setParams(CP_8103_SetParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8103_SetParam{" +
                "params=" + params +
                "} " + super.toString();
    }
}
