/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.VTDR_DATA_0700)
public class JT808AckParams_0700_VtdrData implements JT808AckParams, Cloneable {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;
    private String raw;

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

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808AckParams_0700_VtdrData.class.getSimpleName() + "[", "]")
                .add("cmd=" + cmd)
                .add("dataBlock=" + dataBlock)
                .add("raw='" + raw + "'")
                .toString();
    }

    public void assignFrom(JT808AckParams_0700_VtdrData source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
        this.raw = source.raw;
    }

    @Override
    public JT808AckParams_0700_VtdrData clone() {
        JT808AckParams_0700_VtdrData r = new JT808AckParams_0700_VtdrData();
        r.assignFrom(this);
        return r;
    }
}
