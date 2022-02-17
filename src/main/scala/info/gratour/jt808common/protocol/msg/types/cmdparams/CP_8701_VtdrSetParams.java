/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.VTDR_SET_PARAMS_8701)
public class CP_8701_VtdrSetParams implements JT808CmdParams {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public JT808VtdrDataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(JT808VtdrDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    public void assignFrom(CP_8701_VtdrSetParams source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
    }

    @Override
    public CP_8701_VtdrSetParams clone() {
        CP_8701_VtdrSetParams r = new CP_8701_VtdrSetParams();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_8701_VtdrSetParams.class.getSimpleName() + "[", "]")
                .add("cmd=" + cmd)
                .add("dataBlock=" + dataBlock)
                .toString();
    }
}
