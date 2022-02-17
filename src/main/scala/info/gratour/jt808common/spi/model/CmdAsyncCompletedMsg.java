/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import java.util.StringJoiner;

public class CmdAsyncCompletedMsg {

    public static final String OP_TYP__UPLOAD_AV_RES = "upload-av-res/1206";

    private String simNo;
    private String plateNo;
    private Short plateColor;
    private String opTyp;
    private String cmdId;
    private String cmdArgs;
    private boolean success;
    private int code;
    private int ackSeqNo;
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

    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public String getProvision() {
        return provision;
    }

    public void setProvision(String provision) {
        this.provision = provision;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CmdAsyncCompletedMsg.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("opTyp='" + opTyp + "'")
                .add("cmdId='" + cmdId + "'")
                .add("cmdArgs='" + cmdArgs + "'")
                .add("success=" + success)
                .add("code=" + code)
                .add("ackSeqNo=" + ackSeqNo)
                .add("provision='" + provision + "'")
                .toString();
    }
}
