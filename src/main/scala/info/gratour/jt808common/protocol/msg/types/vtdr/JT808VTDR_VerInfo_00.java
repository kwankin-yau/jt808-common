/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

public class JT808VTDR_VerInfo_00 implements JT808VTDRDataBlock {

    private String year;
    private String rev;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    @Override
    public String toString() {
        return "JT808VTDR_VerInfo_00{" +
                "year='" + year + '\'' +
                ", rev='" + rev + '\'' +
                '}';
    }

    @Override
    public JT808VTDR_VerInfo_00 clone() {
        try {
            return (JT808VTDR_VerInfo_00) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
