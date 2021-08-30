/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

public class TermAsyncCompletedMsg {

    public static final String OP_TYP__UPLOAD_AV_RES = "upload-av-res/1206";

    private String simNo;
    private String plateNo;
    private Short plateColor;
    private String opTyp;
    private String cmdId;
    private String cmdArgs;
    private boolean success;
    private int code;
    private String provision;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    public IPlateNoAndColor getPlateNoAndColor() {
        if (plateNo != null && plateColor != null) {
            PlateNoAndColor r = new PlateNoAndColor();
            r.setPlateNo(plateNo);
            r.setPlateColor(plateColor.intValue());
            return r;
        } else
            return null;
    }

    public String getOpTyp() {
        return opTyp;
    }

    public void setOpTyp(String opTyp) {
        this.opTyp = opTyp;
    }

    public String getCmdId() {
        return cmdId;
    }

    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    public String getCmdArgs() {
        return cmdArgs;
    }

    public void setCmdArgs(String cmdArgs) {
        this.cmdArgs = cmdArgs;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProvision() {
        return provision;
    }

    public void setProvision(String provision) {
        this.provision = provision;
    }

    @Override
    public String toString() {
        return "TermAsyncCompletedMsg{" +
                "simNo='" + simNo + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", opTyp='" + opTyp + '\'' +
                ", cmdId='" + cmdId + '\'' +
                ", cmdArgs='" + cmdArgs + '\'' +
                ", success=" + success +
                ", code=" + code +
                ", provision='" + provision + '\'' +
                '}';
    }
}
