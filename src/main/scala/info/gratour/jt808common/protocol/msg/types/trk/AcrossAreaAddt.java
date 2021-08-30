package info.gratour.jt808common.protocol.msg.types.trk;

/**
 * 进出区域/路线报警附加信息
 */
public class AcrossAreaAddt implements Cloneable {

    public static final int DIR__ENTER = 0;
    public static final int DIR__LEAVE = 1;

    private byte dir;
    private byte typ;
    private int areaId;

    public byte getDir() {
        return dir;
    }

    public void setDir(byte dir) {
        this.dir = dir;
    }

    public boolean isEnter() {
        return dir == DIR__ENTER;
    }

    public boolean isLeave() {
        return dir == DIR__LEAVE;
    }

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
    public AcrossAreaAddt clone() {
        try {
            return (AcrossAreaAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AcrossAreaAddt{" +
                "dir=" + dir +
                ", typ=" + typ +
                ", areaId=" + areaId +
                '}';
    }
}
