/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class JT808VTDR_VehInfo_05 implements JT808VTDRDataBlock {
    private String vin;
    private String plateNo;
    private String plateCategory;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getPlateCategory() {
        return plateCategory;
    }

    public void setPlateCategory(String plateCategory) {
        this.plateCategory = plateCategory;
    }

    @Override
    public String toString() {
        return "JT808VTDR_VehInfo_05{" +
                "vin='" + vin + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", plateCategory='" + plateCategory + '\'' +
                '}';
    }

    @Override
    public JT808VTDR_VehInfo_05 clone() {
        try {
            return (JT808VTDR_VehInfo_05) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
