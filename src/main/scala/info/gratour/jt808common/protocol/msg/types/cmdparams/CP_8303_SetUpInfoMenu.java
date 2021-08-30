/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808InfoMenuItem;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_INFO_MENU_8303)
public class CP_8303_SetUpInfoMenu implements JT808CmdParams {

    private byte action;
    private JT808InfoMenuItem[] menuItems;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808InfoMenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(JT808InfoMenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "CP_8303_SetUpInfoMenu{" +
                "action=" + action +
                ", menuItems=" + Arrays.toString(menuItems) +
                '}';
    }

    public void assignFrom(CP_8303_SetUpInfoMenu source) {
        this.action = source.action;
        if (source.menuItems != null) {
            this.menuItems = new JT808InfoMenuItem[source.menuItems.length];
            for (int i = 0; i < this.menuItems.length; i++)
                this.menuItems[i] = source.menuItems[i].clone();
        } else
            this.menuItems = null;
    }

    @Override
    public CP_8303_SetUpInfoMenu clone() {
        CP_8303_SetUpInfoMenu r = new CP_8303_SetUpInfoMenu();
        r.assignFrom(this);
        return r;
    }
}
