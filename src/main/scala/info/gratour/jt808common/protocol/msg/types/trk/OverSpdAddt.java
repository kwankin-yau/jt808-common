package info.gratour.jt808common.protocol.msg.types.trk;

public class OverSpdAddt implements Cloneable {

    private byte typ;
    private int areaId;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public OverSpdAddt clone() {
        try {
            return (OverSpdAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "OverSpdAddt{" +
                "typ=" + typ +
                ", areaId=" + areaId +
                '}';
    }
}
