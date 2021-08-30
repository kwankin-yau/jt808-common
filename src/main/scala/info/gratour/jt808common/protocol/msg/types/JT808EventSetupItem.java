/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

public class JT808EventSetupItem {

    private byte evtId;
    private String evtContent;

    public byte getEvtId() {
        return evtId;
    }

    public void setEvtId(byte evtId) {
        this.evtId = evtId;
    }

    public String getEvtContent() {
        return evtContent;
    }

    public void setEvtContent(String evtContent) {
        this.evtContent = evtContent;
    }

    @Override
    public String toString() {
        return "JT808EventSetupItem{" +
                "evtId=" + evtId +
                ", evtContent='" + evtContent + '\'' +
                '}';
    }
}
