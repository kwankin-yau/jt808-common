package info.gratour.jt808common.protocol.msg.types.trk;

public class AnalogQty implements Cloneable {

    private int ad0;
    private int ad1;

    public int getAd0() {
        return ad0;
    }

    public void setAd0(int ad0) {
        this.ad0 = ad0;
    }

    public int getAd1() {
        return ad1;
    }

    public void setAd1(int ad1) {
        this.ad1 = ad1;
    }

    @Override
    public AnalogQty clone() {
        try {
            return (AnalogQty) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AnalogQty{" +
                "ad0=" + ad0 +
                ", ad1=" + ad1 +
                '}';
    }
}
