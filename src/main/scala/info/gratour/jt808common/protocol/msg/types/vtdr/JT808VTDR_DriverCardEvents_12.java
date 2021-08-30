/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;

public class JT808VTDR_DriverCardEvents_12 implements JT808VTDRDataBlock {
    private List<VTDR_CardEvent> cardEvents;

    public List<VTDR_CardEvent> getCardEvents() {
        return cardEvents;
    }

    public void setCardEvents(List<VTDR_CardEvent> cardEvents) {
        this.cardEvents = cardEvents;
    }

    public void addCardEvent(VTDR_CardEvent cardEvent) {
        if (this.cardEvents == null)
            this.cardEvents = new ArrayList<>();

        this.cardEvents.add(cardEvent);
    }

    public void assignFrom(JT808VTDR_DriverCardEvents_12 source) {
        if (source.cardEvents != null) {
            this.cardEvents = new ArrayList<>();
            for (VTDR_CardEvent e : source.cardEvents)
                this.cardEvents.add(e.clone());
        } else
            this.cardEvents = null;
    }

    @Override
    public JT808VTDR_DriverCardEvents_12 clone() {
        JT808VTDR_DriverCardEvents_12 r = new JT808VTDR_DriverCardEvents_12();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "JT808VTDR_DriverCardEvents_12{" +
                "cardEvents=" + cardEvents +
                '}';
    }
}
