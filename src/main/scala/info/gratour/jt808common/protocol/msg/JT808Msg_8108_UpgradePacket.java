package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.UPGRADE_PACKET_8108)
public class JT808Msg_8108_UpgradePacket extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.UPGRADE_PACKET_8108;

    public JT808Msg_8108_UpgradePacket() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8108_UpgradePacket(JT808FrameHeader header) {
        super(header);
    }

    private int upgradeType;
    private String factoryId;
    private String version;
    private byte[] data;

    public int getUpgradeType() {
        return upgradeType;
    }

    public void setUpgradeType(int upgradeType) {
        this.upgradeType = upgradeType;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808Msg_8108_UpgradePacket{" +
                "upgradeType=" + upgradeType +
                ", factoryId='" + factoryId + '\'' +
                ", version='" + version + '\'' +
                "} " + super.toString();
    }
}
