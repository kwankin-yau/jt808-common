package info.gratour.jt808common.protocol.msg.types.trk;

public class RouteAlmAddt implements Cloneable {

    private byte typ;
    private int tm;
    private int routeId;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public RouteAlmAddt clone() {
        try {
            return (RouteAlmAddt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "RouteAlarmAddtInfo{" +
                "typ=" + typ +
                ", time=" + tm +
                ", routeId=" + routeId +
                '}';
    }
}
