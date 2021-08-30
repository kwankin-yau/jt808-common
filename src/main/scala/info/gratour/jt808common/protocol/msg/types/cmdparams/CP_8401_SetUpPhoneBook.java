/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808PhoneBookEntry;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_PHONE_BOOK_8401)
public class CP_8401_SetUpPhoneBook implements JT808CmdParams {

    private byte action;
    private JT808PhoneBookEntry[] entries;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808PhoneBookEntry[] getEntries() {
        return entries;
    }

    public void setEntries(JT808PhoneBookEntry[] entries) {
        this.entries = entries;
    }

    public void assignFrom(CP_8401_SetUpPhoneBook source) {
        this.action = source.action;
        if (source.entries != null) {
            this.entries = new JT808PhoneBookEntry[source.entries.length];
            for (int i = 0; i < this.entries.length; i++) {
                this.entries[i] = source.entries[i].clone();
            }
        } else
            this.entries = null;
    }

    @Override
    public CP_8401_SetUpPhoneBook clone() {
        CP_8401_SetUpPhoneBook r = new CP_8401_SetUpPhoneBook();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "CP_8401_SetUpPhoneBook{" +
                "action=" + action +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }
}
