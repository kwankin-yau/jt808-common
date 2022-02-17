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
import java.util.StringJoiner;

public class JT808Vtdr_DriverCardEvents_12 implements JT808VtdrDataBlock {
    private List<Vtdr_CardEvent> cardEvents;

    public List<Vtdr_CardEvent> getCardEvents() {
        return cardEvents;
    }

    public void setCardEvents(List<Vtdr_CardEvent> cardEvents) {
        this.cardEvents = cardEvents;
    }

    public void addCardEvent(Vtdr_CardEvent cardEvent) {
        if (this.cardEvents == null)
            this.cardEvents = new ArrayList<>();

        this.cardEvents.add(cardEvent);
    }

    public void assignFrom(JT808Vtdr_DriverCardEvents_12 source) {
        if (source.cardEvents != null) {
            this.cardEvents = new ArrayList<>();
            for (Vtdr_CardEvent e : source.cardEvents)
                this.cardEvents.add(e.clone());
        } else
            this.cardEvents = null;
    }

    @Override
    public JT808Vtdr_DriverCardEvents_12 clone() {
        JT808Vtdr_DriverCardEvents_12 r = new JT808Vtdr_DriverCardEvents_12();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_DriverCardEvents_12.class.getSimpleName() + "[", "]")
                .add("cardEvents=" + cardEvents)
                .toString();
    }
}
