/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public class MQEventAddt_0100_TermRegister implements MQEventAddt {

    private int provinceId;
    private int cityId;
    private String factoryId;
    private String terminalModel;
    private String terminalId;
    private int plateColor;
    private String plateNo;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0100_TermRegister{" +
                "provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", factoryId='" + factoryId + '\'' +
                ", terminalModel='" + terminalModel + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", plateColor=" + plateColor +
                ", plateNo='" + plateNo + '\'' +
                '}';
    }
}
