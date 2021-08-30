/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VTDRDataBlock;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
public class CP_8700_VTDRDataCollectReq implements JT808CmdParams {

    private byte cmd;
    private JT808VTDRDataBlock dataBlock;

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public JT808VTDRDataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(JT808VTDRDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    public void assignFrom(CP_8700_VTDRDataCollectReq source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
    }

    @Override
    public CP_8700_VTDRDataCollectReq clone() {
        CP_8700_VTDRDataCollectReq r = new CP_8700_VTDRDataCollectReq();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return "CP_8700_VTDRDataCollectReq{" +
                "cmd=" + cmd +
                ", dataBlock=" + dataBlock +
                '}';
    }
}
