package info.gratour.jt808common.protocol.msg.types.trk;

public class UnusualDriveBehav implements Cloneable {
    private short typ;
    private byte tiredLvl;

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public byte getTiredLvl() {
        return tiredLvl;
    }

    public void setTiredLvl(byte tiredLvl) {
        this.tiredLvl = tiredLvl;
    }

    @Override
    public UnusualDriveBehav clone() {
        try {
            return (UnusualDriveBehav) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "UnusualDriveBehavior{" +
                "typ=" + typ +
                ", tiredLvl=" + tiredLvl +
                '}';
    }
}
