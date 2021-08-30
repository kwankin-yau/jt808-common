/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import info.gratour.jt808common.protocol.msg.types.JT808CANData;

import java.util.Arrays;

public class MQEventAddt_0705_CANData implements MQEventAddt {

    private JT808CANData data[];

    public JT808CANData[] getData() {
        return data;
    }

    public void setData(JT808CANData[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0705_CANData{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
