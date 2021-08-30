/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class VTDR_DriveOverTimeEntry implements Cloneable {

    private String licenseNo;
    private String startTime;
    private String endTime;
    private VTDR_Location startLocation;
    private VTDR_Location endLocation;


    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public VTDR_Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(VTDR_Location startLocation) {
        this.startLocation = startLocation;
    }

    public VTDR_Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(VTDR_Location endLocation) {
        this.endLocation = endLocation;
    }

    public void assignFrom(VTDR_DriveOverTimeEntry source) {
        this.licenseNo = source.licenseNo;
        this.startTime = source.startTime;
        this.endTime = source.endTime;
        this.startLocation = source.startLocation != null ? source.startLocation.clone() : null;
        this.endLocation = source.endLocation != null ? source.endLocation.clone() : null;
    }

    @Override
    public VTDR_DriveOverTimeEntry clone() {
        VTDR_DriveOverTimeEntry r = new VTDR_DriveOverTimeEntry();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "VTDR_DriveOverTimeEntry{" +
                "licenseNo='" + licenseNo + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                '}';
    }
}
