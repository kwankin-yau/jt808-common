/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_8802_StoredMediaSearch;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.STORED_MEDIA_SEARCH_8802)
public class JT808Msg_8802_StoredMediaSearch extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.STORED_MEDIA_SEARCH_8802;

    public JT808Msg_8802_StoredMediaSearch() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8802_StoredMediaSearch(JT808FrameHeader header) {
        super(header);
    }

    private CP_8802_StoredMediaSearch params;

    public CP_8802_StoredMediaSearch getParams() {
        return params;
    }

    public void setParams(CP_8802_StoredMediaSearch params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8802_StoredMediaSearch{" +
                "params=" + params +
                "} " + super.toString();
    }
}
