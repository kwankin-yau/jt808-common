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
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CP_9212_AlmAttFileItemCompleted;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_9212)
public class JTAdasMsg_9212_AlmAttFileItemCompleted extends JT808Msg {

    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_9212;



    public JTAdasMsg_9212_AlmAttFileItemCompleted() {
        setMsgId(MSG_ID);
    }

    public JTAdasMsg_9212_AlmAttFileItemCompleted(JT808FrameHeader header) {
        super(header);
    }

    private CP_9212_AlmAttFileItemCompleted params;

    public CP_9212_AlmAttFileItemCompleted getParams() {
        return params;
    }

    public void setParams(CP_9212_AlmAttFileItemCompleted params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JTAdasMsg_9212_AlmAttFileItemCompleted{" +
                "params=" + params +
                '}';
    }
}
