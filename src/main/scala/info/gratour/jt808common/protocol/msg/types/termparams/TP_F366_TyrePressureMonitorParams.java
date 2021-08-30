/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_F366_TyrePressureMonitorParams {

    private String tyreModel;
    private short pressureUnit;
    private int normalPressureValue;
    private short imbalanceThreshold;
    private short airLeakSlowlyThreshold;
    private short lowPressureThreshold;
    private short highPressureThreshold;
    private short highTemperatureThreshold;
    private short voltageThreshold;
    private short reportInterval;

    public String getTyreModel() {
        return tyreModel;
    }

    public void setTyreModel(String tyreModel) {
        this.tyreModel = tyreModel;
    }

    public short getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(short pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public int getNormalPressureValue() {
        return normalPressureValue;
    }

    public void setNormalPressureValue(int normalPressureValue) {
        this.normalPressureValue = normalPressureValue;
    }

    public short getImbalanceThreshold() {
        return imbalanceThreshold;
    }

    public void setImbalanceThreshold(short imbalanceThreshold) {
        this.imbalanceThreshold = imbalanceThreshold;
    }

    public short getAirLeakSlowlyThreshold() {
        return airLeakSlowlyThreshold;
    }

    public void setAirLeakSlowlyThreshold(short airLeakSlowlyThreshold) {
        this.airLeakSlowlyThreshold = airLeakSlowlyThreshold;
    }

    public short getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public void setLowPressureThreshold(short lowPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
    }

    public short getHighPressureThreshold() {
        return highPressureThreshold;
    }

    public void setHighPressureThreshold(short highPressureThreshold) {
        this.highPressureThreshold = highPressureThreshold;
    }

    public short getHighTemperatureThreshold() {
        return highTemperatureThreshold;
    }

    public void setHighTemperatureThreshold(short highTemperatureThreshold) {
        this.highTemperatureThreshold = highTemperatureThreshold;
    }

    public short getVoltageThreshold() {
        return voltageThreshold;
    }

    public void setVoltageThreshold(short voltageThreshold) {
        this.voltageThreshold = voltageThreshold;
    }

    public short getReportInterval() {
        return reportInterval;
    }

    public void setReportInterval(short reportInterval) {
        this.reportInterval = reportInterval;
    }

    @Override
    public String toString() {
        return "TP_F366_TyrePressureMonitorParams{" +
                "tyreModel='" + tyreModel + '\'' +
                ", pressureUnit=" + pressureUnit +
                ", normalPressureValue=" + normalPressureValue +
                ", imbalanceThreshold=" + imbalanceThreshold +
                ", airLeakSlowlyThreshold=" + airLeakSlowlyThreshold +
                ", lowPressureThreshold=" + lowPressureThreshold +
                ", highPressureThreshold=" + highPressureThreshold +
                ", highTemperatureThreshold=" + highTemperatureThreshold +
                ", voltageThreshold=" + voltageThreshold +
                ", reportInterval=" + reportInterval +
                '}';
    }
}
