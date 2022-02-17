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

public class JT808Vtdr_RevEvents_14 implements JT808VtdrDataBlock {

    private List<Vtdr_RevEvent> revEvents;

    public List<Vtdr_RevEvent> getRevEvents() {
        return revEvents;
    }

    public void setRevEvents(List<Vtdr_RevEvent> revEvents) {
        this.revEvents = revEvents;
    }

    public void addRevEvent(Vtdr_RevEvent event) {
        if (this.revEvents == null)
            this.revEvents = new ArrayList<>();

        this.revEvents.add(event);
    }

    public void assignFrom(JT808Vtdr_RevEvents_14 source) {
        if (source.revEvents != null) {
            this.revEvents = new ArrayList<>();
            for (Vtdr_RevEvent e : source.revEvents)
                this.revEvents.add(e.clone());
        } else
            this.revEvents = null;
    }

    @Override
    public JT808Vtdr_RevEvents_14 clone() {
        JT808Vtdr_RevEvents_14 r = new JT808Vtdr_RevEvents_14();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_RevEvents_14.class.getSimpleName() + "[", "]")
                .add("revEvents=" + revEvents)
                .toString();
    }
}
