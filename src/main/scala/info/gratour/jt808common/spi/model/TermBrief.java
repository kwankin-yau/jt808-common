/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 简明终端信息
 */
public interface TermBrief {

    /**
     * 终端协议：支持808协议
     */
    int TERM_PROTO__808 = 1 << 0;

    /**
     * 终端协议：支持1078
     */
    int TERM_PROTO__1078 = 1 << 1;

    /**
     * 终端类型：支持ADAS
     */
    int TERM_PROTO__ADAS = 1 << 2;

    default boolean termProtoSupport1078(int protoTyp) {
        return (protoTyp & TERM_PROTO__1078) != 0;
    }

    /**
     * 取终端所属的应用的ID
     *
     * @return 终端所属的应用的ID
     */
    String getAppId();

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    String getSimNo();

    /**
     * 取关联的车辆的ID
     *
     * @return 关联的车辆的ID，未关联车辆时，返回 null
     */
    @Nullable
    String getVehId();

    /**
     * 取关联的车辆的车牌号
     *
     * @return 关联的车牌号，未关联车辆时，返回 null
     */
    @Nullable
    String getPlateNo();

    /**
     * 取关联的车辆的车牌颜色代码。参见：`info.gratour.jtcommon.JTMessages.PlateColors`
     *
     * @return 关联的车牌颜色代码，未关联的车辆时，返回 null
     */
    @Nullable
    Integer getPlateColor();

    default IPlateNoAndColor getPlateNoAndColor() {
        String pn = getPlateNo();
        Integer clr = getPlateColor();
        if (pn != null && clr != null) {
            return new PlateNoAndColor(pn, clr);
        } else
            return null;
    }
}
