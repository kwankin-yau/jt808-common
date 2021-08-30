package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.UPGRADE_RESULT_0108)
public class JT808Msg_0108_UpgradeResult extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.UPGRADE_RESULT_0108;

    public JT808Msg_0108_UpgradeResult() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0108_UpgradeResult(JT808FrameHeader header) {
        super(header);
    }

    private byte upgradeType;
    private byte result;

    public byte getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(byte upgradeType) {
        this.upgradeType = upgradeType;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT808Msg_0108_UpgradeResult{" +
                "upgradeType=" + upgradeType +
                ", result=" + result +
                "} " + super.toString();
    }
}
