/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class JT808Vtdr_VerInfo_00 implements JT808VtdrDataBlock {

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
        return new StringJoiner(", ", JT808Vtdr_VerInfo_00.class.getSimpleName() + "[", "]")
                .add("year='" + year + "'")
                .add("rev='" + rev + "'")
                .toString();
    }

    @Override
    public JT808Vtdr_VerInfo_00 clone() {
        try {
            return (JT808Vtdr_VerInfo_00) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
