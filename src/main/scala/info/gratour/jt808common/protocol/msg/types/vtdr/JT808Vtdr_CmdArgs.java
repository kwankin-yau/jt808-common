/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class JT808Vtdr_CmdArgs implements JT808VtdrDataBlock {

    private String startTime;
    private String endTime;
    private int blockCnt;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getBlockCnt() {
        return blockCnt;
    }

    public void setBlockCnt(int blockCnt) {
        this.blockCnt = blockCnt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_CmdArgs.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("blockCnt=" + blockCnt)
                .toString();
    }

    @Override
    public JT808Vtdr_CmdArgs clone() {
        try {
            return (JT808Vtdr_CmdArgs) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
