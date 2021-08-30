/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.Arrays;

public class JT808CANData {


    private int id;
    private boolean can2;
    private boolean extFrame;
    private boolean calculated;
    private byte[] data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCan2() {
        return can2;
    }

    public void setCan2(boolean can2) {
        this.can2 = can2;
    }

    public boolean isExtFrame() {
        return extFrame;
    }

    public void setExtFrame(boolean extFrame) {
        this.extFrame = extFrame;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JT808CANData{" +
                "id=" + id +
                ", can2=" + can2 +
                ", extFrame=" + extFrame +
                ", calculated=" + calculated +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
