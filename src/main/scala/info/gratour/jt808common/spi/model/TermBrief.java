/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

public interface TermBrief {

    public static final int TERM_TYPE__2G = 0;
    public static final int TERM_TYPE__1078 = 1;
    public static final int TERM_TYPE__ADAS = 2;

    default boolean termTypSupport1078(int typ) {
        switch (typ) {
            case TERM_TYPE__1078:
            case TERM_TYPE__ADAS:
                return true;

            default:
                return false;
        }
    }


    String getSimNo();

    String getVehId();
    String getPlateNo();
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
