package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams_0107_QryAttrsAck;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107)
public class JT808Msg_0107_QryAttrsAck extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107;

    public JT808Msg_0107_QryAttrsAck() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0107_QryAttrsAck(JT808FrameHeader header) {
        super(header);
    }

    private JT808AckParams_0107_QryAttrsAck attrs;

    public JT808AckParams_0107_QryAttrsAck getAttrs() {
        return attrs;
    }

    public void setAttrs(JT808AckParams_0107_QryAttrsAck attrs) {
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        return "JT808Msg_0107_QryAttrsAck{" +
                "attrs=" + attrs +
                "} " + super.toString();
    }
}
