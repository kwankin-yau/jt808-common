/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.trk;

import com.google.gson.reflect.TypeToken;
import info.gratour.jtcommon.JTConsts;

import java.lang.reflect.Type;

/**
 * 轨迹附加信息
 */
public class TrkAddt implements Cloneable {

    public static final Type TYPE = new TypeToken<TrkAddt>() {
    }.getType();

    private String id;

    /**
     * 卫星数
     */
    private Short sat;

    /**
     * 网络信号强度
     */
    private Short netSigStr;

    private Integer confirmAlmId;
    private OverSpdAddt overSpd;
    private AcrossAreaAddt acrossArea;
    private RouteAlmAddt routeAlm;
    private AnalogQty anQty;

    /**
     * 视频丢失报警状态字
     */
    private Integer vidLoss;

    /**
     * 视频遮挡报警状态字
     */
    private Integer vidCover;

    /**
     * 视频存储报警状态字
     */
    private Short vidStgAlm;

    /**
     * 异常驾驶行为报警
     */
    private UnusualDriveBehav unusualDriveBehav;

    /**
     * adas
     */
    private AdasDrivingAssistAlmAddt drivingAssistAlm;
    private AdasDriverBehavAlmAddt driverBehavAlm;
    private AdasTyreState tyreState;
    private AdasBlindAreaAlmAddt blindArea;
    private AdasIntenseDrivingAlmAddt intenseDrivingAlm;
    private AdasOverSpdAlmAddt adasOverSpd;
    private AdasAiRecogAlmAddt aiRecogAlm;
    private AdasOverloadAlmAddt overloadAlmAddt;
    private AdasOverHeightAlmAddt overHeightAlmAddt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getSat() {
        return sat;
    }

    public void setSat(Short sat) {
        this.sat = sat;
    }

    public Short getNetSigStr() {
        return netSigStr;
    }

    public void setNetSigStr(Short netSigStr) {
        this.netSigStr = netSigStr;
    }

    public Integer getConfirmAlmId() {
        return confirmAlmId;
    }

    public void setConfirmAlmId(Integer confirmAlmId) {
        this.confirmAlmId = confirmAlmId;
    }

    public OverSpdAddt getOverSpd() {
        return overSpd;
    }

    public void setOverSpd(OverSpdAddt overSpd) {
        this.overSpd = overSpd;
    }

    public AcrossAreaAddt getAcrossArea() {
        return acrossArea;
    }

    public void setAcrossArea(AcrossAreaAddt acrossArea) {
        this.acrossArea = acrossArea;
    }

    public RouteAlmAddt getRouteAlm() {
        return routeAlm;
    }

    public void setRouteAlm(RouteAlmAddt routeAlm) {
        this.routeAlm = routeAlm;
    }

    public AnalogQty getAnQty() {
        return anQty;
    }

    public void setAnQty(AnalogQty anQty) {
        this.anQty = anQty;
    }

    public Integer getVidLoss() {
        return vidLoss;
    }

    public void setVidLoss(Integer vidLoss) {
        this.vidLoss = vidLoss;
    }

    public Integer getVidCover() {
        return vidCover;
    }

    public void setVidCover(Integer vidCover) {
        this.vidCover = vidCover;
    }

    public Short getVidStgAlm() {
        return vidStgAlm;
    }

    public void setVidStgAlm(Short vidStgAlm) {
        this.vidStgAlm = vidStgAlm;
    }

    public UnusualDriveBehav getUnusualDriveBehav() {
        return unusualDriveBehav;
    }

    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        this.unusualDriveBehav = unusualDriveBehav;
    }

    public AdasDrivingAssistAlmAddt getDrivingAssistAlm() {
        return drivingAssistAlm;
    }

    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt drivingAssistAlm) {
        this.drivingAssistAlm = drivingAssistAlm;
    }

    public AdasDriverBehavAlmAddt getDriverBehavAlm() {
        return driverBehavAlm;
    }

    public void setDriverBehavAlm(AdasDriverBehavAlmAddt driverBehavAlm) {
        this.driverBehavAlm = driverBehavAlm;
    }

    public AdasTyreState getTyreState() {
        return tyreState;
    }

    public void setTyreState(AdasTyreState tyreState) {
        this.tyreState = tyreState;
    }

    public AdasBlindAreaAlmAddt getBlindArea() {
        return blindArea;
    }

    public void setBlindArea(AdasBlindAreaAlmAddt blindArea) {
        this.blindArea = blindArea;
    }

    public AdasIntenseDrivingAlmAddt getIntenseDrivingAlm() {
        return intenseDrivingAlm;
    }

    public void setIntenseDrivingAlm(AdasIntenseDrivingAlmAddt intenseDrivingAlm) {
        this.intenseDrivingAlm = intenseDrivingAlm;
    }

    public AdasOverSpdAlmAddt getAdasOverSpd() {
        return adasOverSpd;
    }

    public void setAdasOverSpd(AdasOverSpdAlmAddt adasOverSpd) {
        this.adasOverSpd = adasOverSpd;
    }

    public AdasAiRecogAlmAddt getAiRecogAlm() {
        return aiRecogAlm;
    }

    public void setAiRecogAlm(AdasAiRecogAlmAddt aiRecogAlm) {
        this.aiRecogAlm = aiRecogAlm;
    }

    public AdasOverloadAlmAddt getOverloadAlmAddt() {
        return overloadAlmAddt;
    }

    public void setOverloadAlmAddt(AdasOverloadAlmAddt overloadAlmAddt) {
        this.overloadAlmAddt = overloadAlmAddt;
    }

    public AdasOverHeightAlmAddt getOverHeightAlmAddt() {
        return overHeightAlmAddt;
    }

    public void setOverHeightAlmAddt(AdasOverHeightAlmAddt overHeightAlmAddt) {
        this.overHeightAlmAddt = overHeightAlmAddt;
    }

    public void assignFrom(TrkAddt source) {
        this.id = source.id;
        this.sat = source.sat;
        this.netSigStr = source.netSigStr;
        this.confirmAlmId = source.confirmAlmId;
        this.overSpd = source.overSpd;
        this.acrossArea = source.acrossArea;
        this.routeAlm = source.routeAlm;
        this.anQty = source.anQty;
        this.vidLoss = source.vidLoss;
        this.vidCover = source.vidCover;
        this.vidStgAlm = source.vidStgAlm;
        this.unusualDriveBehav = source.unusualDriveBehav != null ? source.unusualDriveBehav.clone() : null;
        this.drivingAssistAlm = source.drivingAssistAlm != null ? source.drivingAssistAlm.clone() : null;
        this.driverBehavAlm = source.driverBehavAlm != null ? source.driverBehavAlm.clone() : null;
        this.tyreState = source.tyreState != null ? source.tyreState.clone() : null;
        this.blindArea = source.blindArea != null ? source.blindArea.clone() : null;
        this.intenseDrivingAlm = source.intenseDrivingAlm != null ? source.intenseDrivingAlm.clone() : null;
        this.adasOverSpd = source.adasOverSpd != null ? source.adasOverSpd.clone() : null;
        this.aiRecogAlm = source.aiRecogAlm != null ? source.aiRecogAlm.clone() : null;
        this.overloadAlmAddt = source.overloadAlmAddt != null ? source.overloadAlmAddt.clone() : null;
        this.overHeightAlmAddt = source.overHeightAlmAddt != null ? source.overHeightAlmAddt.clone() : null;
    }

    @Override
    public TrkAddt clone() {
        TrkAddt r = new TrkAddt();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return JTConsts.GSON().toJson(this);
    }
}
