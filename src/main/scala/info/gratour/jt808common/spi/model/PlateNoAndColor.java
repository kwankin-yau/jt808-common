/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

public class PlateNoAndColor implements IPlateNoAndColor {

    private String plateNo;
    private int plateColor;

    public PlateNoAndColor() {
    }

    public PlateNoAndColor(String plateNo, int plateColor) {
        this.plateNo = plateNo;
        this.plateColor = plateColor;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public short plateColorShort() {
        return (short) plateColor;
    }

    public byte plateColorByte() {
        return (byte) plateColor;
    }

    public static PlateNoAndColor parseFromPlateNoStr(String plateNoStr) {
        if (plateNoStr == null)
            return null;
        else {
            int p = plateNoStr.indexOf('_');
            if (p < 0)
                throw new RuntimeException(String.format("Can not parse PlateNo string: `%s`.", plateNoStr));

            return new PlateNoAndColor(plateNoStr.substring(0, p),  Integer.parseInt(plateNoStr.substring(p+1)));
        }
    }

    @Override
    public String toString() {
        return "PlateNoAndColor{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                '}';
    }
}
