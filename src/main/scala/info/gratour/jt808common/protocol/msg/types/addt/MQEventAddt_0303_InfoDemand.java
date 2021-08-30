/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public class MQEventAddt_0303_InfoDemand implements MQEventAddt {
    private byte infoType;
    private byte ctrlType;

    public byte getInfoType() {
        return infoType;
    }

    public void setInfoType(byte infoType) {
        this.infoType = infoType;
    }

    public byte getCtrlType() {
        return ctrlType;
    }

    public void setCtrlType(byte ctrlType) {
        this.ctrlType = ctrlType;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0303_InfoDemand{" +
                "infoType=" + infoType +
                ", ctrlType=" + ctrlType +
                '}';
    }
}
