/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public class MQEventAddt_0301_EventReport implements MQEventAddt {

    private short eventId;

    public short getEventId() {
        return eventId;
    }

    public void setEventId(short eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "MQEventAddt_0301_EventReport{" +
                "eventId=" + eventId +
                '}';
    }
}
