/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_1212)
public class JTAdasMsg_1212_FileItemCompleted extends JT808Msg {

    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_1212;

    public JTAdasMsg_1212_FileItemCompleted() {
        setMsgId(MSG_ID);
    }

    public JTAdasMsg_1212_FileItemCompleted(JT808FrameHeader header) {
        super(header);
    }

    private AlmAttFileItemWithType item;

    public AlmAttFileItemWithType getItem() {
        return item;
    }

    public void setItem(AlmAttFileItemWithType item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "JTAdasMsg_1212_FileItemCompleted{" +
                "item=" + item +
                '}';
    }
}
