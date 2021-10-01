/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttReTransFileBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.ArrayList;
import java.util.List;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_9212)
public class CP_9212_AlmAttFileItemCompleted implements JT808CmdParams {

    public static final byte RESULT__COMPLETED = 0;
    public static final byte RESULT__RETRANSMIT_NEEDED = 1;

    private AlmAttFileItemWithType fileItem;
    private List<AlmAttReTransFileBlock> reTransFileBlocks;

    public AlmAttFileItemWithType getFileItem() {
        return fileItem;
    }

    public void setFileItem(AlmAttFileItemWithType fileItem) {
        this.fileItem = fileItem;
    }

    public List<AlmAttReTransFileBlock> getReTransFileBlocks() {
        return reTransFileBlocks;
    }

    public void setReTransFileBlocks(List<AlmAttReTransFileBlock> reTransFileBlocks) {
        this.reTransFileBlocks = reTransFileBlocks;
    }

    @Override
    public String toString() {
        return "CP_9212_AlmAttFileItemCompleted{" +
                "fileItem=" + fileItem +
                ", reTransFileBlocks=" + reTransFileBlocks +
                '}';
    }

    public void assignFrom(CP_9212_AlmAttFileItemCompleted source) {
        this.fileItem = source.fileItem != null ? source.fileItem.clone() : null;
        if (source.reTransFileBlocks != null) {
            this.reTransFileBlocks = new ArrayList<>();
            for (AlmAttReTransFileBlock b : source.reTransFileBlocks) {
                this.reTransFileBlocks.add(b.clone());
            }
        } else
            this.reTransFileBlocks = null;
    }

    @Override
    public CP_9212_AlmAttFileItemCompleted clone() {
        CP_9212_AlmAttFileItemCompleted r = new CP_9212_AlmAttFileItemCompleted();
        r.assignFrom(this);
        return r;
    }
}
