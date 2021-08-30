/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_F370_IntenseDrivingMonitorParams {

    private int enableFlags;
    private short accelerateTimeThreshold;
    private short accelerateSpeedThreshold;
    private short brakeTimeThreshold;
    private short brakeSpeedThreshold;
    private short turnTimeThreshold;
    private short turnSpeedThreshold;
    private short idlingTimeThreshold;
    private short idlingSpeedThreshold;
    private short idlingRotationalSpeedThreshold;
    private short flameOutTimeThreshold;
    private short flameOutSpeedThreshold;
    private short flameOutRotationalSpeedThreshold;
    private short neutralTimeThreshold;
    private short neutralSpeedThreshold;
    private short neutralRotationalSpeedThreshold;
    private short rotationalSpeedTimeThreshold;
    private short rotationalSpeedSpeedThreshold;
    private short rotationalSpeedRpmThreshold;

    public int getEnableFlags() {
        return enableFlags;
    }

    public void setEnableFlags(int enableFlags) {
        this.enableFlags = enableFlags;
    }

    public short getAccelerateTimeThreshold() {
        return accelerateTimeThreshold;
    }

    public void setAccelerateTimeThreshold(short accelerateTimeThreshold) {
        this.accelerateTimeThreshold = accelerateTimeThreshold;
    }

    public short getAccelerateSpeedThreshold() {
        return accelerateSpeedThreshold;
    }

    public void setAccelerateSpeedThreshold(short accelerateSpeedThreshold) {
        this.accelerateSpeedThreshold = accelerateSpeedThreshold;
    }

    public short getBrakeTimeThreshold() {
        return brakeTimeThreshold;
    }

    public void setBrakeTimeThreshold(short brakeTimeThreshold) {
        this.brakeTimeThreshold = brakeTimeThreshold;
    }

    public short getBrakeSpeedThreshold() {
        return brakeSpeedThreshold;
    }

    public void setBrakeSpeedThreshold(short brakeSpeedThreshold) {
        this.brakeSpeedThreshold = brakeSpeedThreshold;
    }

    public short getTurnTimeThreshold() {
        return turnTimeThreshold;
    }

    public void setTurnTimeThreshold(short turnTimeThreshold) {
        this.turnTimeThreshold = turnTimeThreshold;
    }

    public short getTurnSpeedThreshold() {
        return turnSpeedThreshold;
    }

    public void setTurnSpeedThreshold(short turnSpeedThreshold) {
        this.turnSpeedThreshold = turnSpeedThreshold;
    }

    public short getIdlingTimeThreshold() {
        return idlingTimeThreshold;
    }

    public void setIdlingTimeThreshold(short idlingTimeThreshold) {
        this.idlingTimeThreshold = idlingTimeThreshold;
    }

    public short getIdlingSpeedThreshold() {
        return idlingSpeedThreshold;
    }

    public void setIdlingSpeedThreshold(short idlingSpeedThreshold) {
        this.idlingSpeedThreshold = idlingSpeedThreshold;
    }

    public short getIdlingRotationalSpeedThreshold() {
        return idlingRotationalSpeedThreshold;
    }

    public void setIdlingRotationalSpeedThreshold(short idlingRotationalSpeedThreshold) {
        this.idlingRotationalSpeedThreshold = idlingRotationalSpeedThreshold;
    }

    public short getFlameOutTimeThreshold() {
        return flameOutTimeThreshold;
    }

    public void setFlameOutTimeThreshold(short flameOutTimeThreshold) {
        this.flameOutTimeThreshold = flameOutTimeThreshold;
    }

    public short getFlameOutSpeedThreshold() {
        return flameOutSpeedThreshold;
    }

    public void setFlameOutSpeedThreshold(short flameOutSpeedThreshold) {
        this.flameOutSpeedThreshold = flameOutSpeedThreshold;
    }

    public short getFlameOutRotationalSpeedThreshold() {
        return flameOutRotationalSpeedThreshold;
    }

    public void setFlameOutRotationalSpeedThreshold(short flameOutRotationalSpeedThreshold) {
        this.flameOutRotationalSpeedThreshold = flameOutRotationalSpeedThreshold;
    }

    public short getNeutralTimeThreshold() {
        return neutralTimeThreshold;
    }

    public void setNeutralTimeThreshold(short neutralTimeThreshold) {
        this.neutralTimeThreshold = neutralTimeThreshold;
    }

    public short getNeutralSpeedThreshold() {
        return neutralSpeedThreshold;
    }

    public void setNeutralSpeedThreshold(short neutralSpeedThreshold) {
        this.neutralSpeedThreshold = neutralSpeedThreshold;
    }

    public short getNeutralRotationalSpeedThreshold() {
        return neutralRotationalSpeedThreshold;
    }

    public void setNeutralRotationalSpeedThreshold(short neutralRotationalSpeedThreshold) {
        this.neutralRotationalSpeedThreshold = neutralRotationalSpeedThreshold;
    }

    public short getRotationalSpeedTimeThreshold() {
        return rotationalSpeedTimeThreshold;
    }

    public void setRotationalSpeedTimeThreshold(short rotationalSpeedTimeThreshold) {
        this.rotationalSpeedTimeThreshold = rotationalSpeedTimeThreshold;
    }

    public short getRotationalSpeedSpeedThreshold() {
        return rotationalSpeedSpeedThreshold;
    }

    public void setRotationalSpeedSpeedThreshold(short rotationalSpeedSpeedThreshold) {
        this.rotationalSpeedSpeedThreshold = rotationalSpeedSpeedThreshold;
    }

    public short getRotationalSpeedRpmThreshold() {
        return rotationalSpeedRpmThreshold;
    }

    public void setRotationalSpeedRpmThreshold(short rotationalSpeedRpmThreshold) {
        this.rotationalSpeedRpmThreshold = rotationalSpeedRpmThreshold;
    }

    @Override
    public String toString() {
        return "TP_F370_IntenseDrivingMonitorParams{" +
                "enableFlags=" + enableFlags +
                ", accelerateTimeThreshold=" + accelerateTimeThreshold +
                ", accelerateSpeedThreshold=" + accelerateSpeedThreshold +
                ", brakeTimeThreshold=" + brakeTimeThreshold +
                ", brakeSpeedThreshold=" + brakeSpeedThreshold +
                ", turnTimeThreshold=" + turnTimeThreshold +
                ", turnSpeedThreshold=" + turnSpeedThreshold +
                ", idlingTimeThreshold=" + idlingTimeThreshold +
                ", idlingSpeedThreshold=" + idlingSpeedThreshold +
                ", idlingRotationalSpeedThreshold=" + idlingRotationalSpeedThreshold +
                ", flameOutTimeThreshold=" + flameOutTimeThreshold +
                ", flameOutSpeedThreshold=" + flameOutSpeedThreshold +
                ", flameOutRotationalSpeedThreshold=" + flameOutRotationalSpeedThreshold +
                ", neutralTimeThreshold=" + neutralTimeThreshold +
                ", neutralSpeedThreshold=" + neutralSpeedThreshold +
                ", neutralRotationalSpeedThreshold=" + neutralRotationalSpeedThreshold +
                ", rotationalSpeedTimeThreshold=" + rotationalSpeedTimeThreshold +
                ", rotationalSpeedSpeedThreshold=" + rotationalSpeedSpeedThreshold +
                ", rotationalSpeedRpmThreshold=" + rotationalSpeedRpmThreshold +
                '}';
    }
}
