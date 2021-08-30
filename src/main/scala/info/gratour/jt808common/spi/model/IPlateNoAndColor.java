/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

/**
 * Plate number and color
 */
public interface IPlateNoAndColor {
    String getPlateNo();
    int getPlateColor();

    static String plateNoString(String plateNo, int plateColor) {
        if (plateNo == null)
            throw new NullPointerException("plateNo");

        return plateNo + "_" + plateColor;
    }

    default String plateNoStr() {
        return getPlateNo() + "_" + getPlateColor();
    }
}
