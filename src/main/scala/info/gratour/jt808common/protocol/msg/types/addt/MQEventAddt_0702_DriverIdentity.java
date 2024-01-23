/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.DRIVER_IDENTITY_0702)
public class MQEventAddt_0702_DriverIdentity implements MQEventAddt, JT808AckParams {

    public static final short ACT__LOGIN = 1;
    public static final short ACT__LOGOUT = 2;

    public static final short READ_STATE__OK = 0;

    private short state;
    private long time;
    private Short readState;
    private String driverName;
    private String licenseNo;
    private String issuer;
    private String expireDate;
    private String idCardNum;

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Short getReadState() {
        return readState;
    }

    public void setReadState(Short readState) {
        this.readState = readState;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Get ID Card Number of the driver. Introduced by REV_2019.
     * @return ID Card Number of the driver.
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0702_DriverIdentity{" +
                "state=" + state +
                ", time=" + time +
                ", readState=" + readState +
                ", driverName='" + driverName + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", issuer='" + issuer + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                '}';
    }

    @Override
    public MQEventAddt_0702_DriverIdentity clone() {
        try {
            return (MQEventAddt_0702_DriverIdentity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
