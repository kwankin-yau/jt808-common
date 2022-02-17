/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_DriveOverTimeEntry implements Cloneable {

    private String licenseNo;
    private String startTime;
    private String endTime;
    private Vtdr_Location startLocation;
    private Vtdr_Location endLocation;


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

    public Vtdr_Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Vtdr_Location startLocation) {
        this.startLocation = startLocation;
    }

    public Vtdr_Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Vtdr_Location endLocation) {
        this.endLocation = endLocation;
    }

    public void assignFrom(Vtdr_DriveOverTimeEntry source) {
        this.licenseNo = source.licenseNo;
        this.startTime = source.startTime;
        this.endTime = source.endTime;
        this.startLocation = source.startLocation != null ? source.startLocation.clone() : null;
        this.endLocation = source.endLocation != null ? source.endLocation.clone() : null;
    }

    @Override
    public Vtdr_DriveOverTimeEntry clone() {
        Vtdr_DriveOverTimeEntry r = new Vtdr_DriveOverTimeEntry();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_DriveOverTimeEntry.class.getSimpleName() + "[", "]")
                .add("licenseNo='" + licenseNo + "'")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("startLocation=" + startLocation)
                .add("endLocation=" + endLocation)
                .toString();
    }
}
