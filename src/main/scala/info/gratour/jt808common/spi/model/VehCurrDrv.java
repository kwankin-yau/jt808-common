/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

/**
 * The current driver card information associated with vehicle
 */
public class VehCurrDrv implements IPlateNoAndColor {

    private String plateNo;
    private int plateColor;
    private String drvName;
    private String drvNo;
    private String licenseNo;
    private String issuer;
    private String expireDate;

    @Override
    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvNo() {
        return drvNo;
    }

    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
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

    @Override
    public String toString() {
        return "VehCurrDrv{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", issuer='" + issuer + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
