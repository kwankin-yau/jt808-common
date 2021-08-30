/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.LOCATION_TRACE_CTRL_8202)
public class CP_8202_LocationTraceCtrl implements JT808CmdParams {

    private int interval;
    private Integer duration;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "CP_8202_LocationTraceCtrl{" +
                "interval=" + interval +
                ", duration=" + duration +
                '}';
    }

    @Override
    public CP_8202_LocationTraceCtrl clone() {
        try {
            return (CP_8202_LocationTraceCtrl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
