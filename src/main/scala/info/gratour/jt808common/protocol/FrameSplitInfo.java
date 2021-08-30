package info.gratour.jt808common.protocol;

public class FrameSplitInfo {

    private int totalPacket;
    private int packetSeqNo;

    public int getTotalPacket() {
        return totalPacket;
    }

    public void setTotalPacket(int totalPacket) {
        this.totalPacket = totalPacket;
    }

    public int getPacketSeqNo() {
        return packetSeqNo;
    }

    public void setPacketSeqNo(int packetSeqNo) {
        this.packetSeqNo = packetSeqNo;
    }

    @Override
    public String toString() {
        return "FrameSplitInfo{" +
                "totalPacket=" + totalPacket +
                ", packetSeqNo=" + packetSeqNo +
                '}';
    }
}
