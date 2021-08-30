/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

public class MQEventAddt_1005_PassengerTraffic implements MQEventAddt {


    private long startTime;
    private long endTime;
    private int getOnCount;
    private int getOffCount;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getGetOnCount() {
        return getOnCount;
    }

    public void setGetOnCount(int getOnCount) {
        this.getOnCount = getOnCount;
    }

    public int getGetOffCount() {
        return getOffCount;
    }

    public void setGetOffCount(int getOffCount) {
        this.getOffCount = getOffCount;
    }

    @Override
    public String toString() {
        return "MQEventAddt_1005_PassengerTraffic{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", getOnCount=" + getOnCount +
                ", getOffCount=" + getOffCount +
                '}';
    }
}
