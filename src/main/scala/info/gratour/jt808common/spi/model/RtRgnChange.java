package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class RtRgnChange {

    public static final Type TYPE = new TypeToken<RtRgnChange>(){}.getType();

    public static final String TYP__ROUTE = "rt";
    public static final String TYP__REGION = "rgn";
    public static final String TYP__PLAT_RGN = "plat_rgn";

    public static final int ACTION__UPDATE = 0;
    public static final int ACTION__DELETE = 1;

    private String typ;
    private String id;
    private String simNo;
    private int action;
    private boolean enabled;
    private Object params;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RtRgnChange{" +
                "typ='" + typ + '\'' +
                ", id='" + id + '\'' +
                ", simNo='" + simNo + '\'' +
                ", action=" + action +
                ", enabled=" + enabled +
                ", params=" + params +
                '}';
    }
}
