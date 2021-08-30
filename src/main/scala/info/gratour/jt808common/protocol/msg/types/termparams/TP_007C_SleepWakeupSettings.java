/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.termparams;

public class TP_007C_SleepWakeupSettings {

    public static class DailyWakeupSetting {
        private byte periodEnableFlags;
        private String period1WakeupTime;
        private String period1SleepTime;

        private String period2WakeupTime;
        private String period2SleepTime;

        private String period3WakeupTime;
        private String period3SleepTime;

        private String period4WakeupTime;
        private String period4SleepTime;

        public byte getPeriodEnableFlags() {
            return periodEnableFlags;
        }

        public void setPeriodEnableFlags(byte periodEnableFlags) {
            this.periodEnableFlags = periodEnableFlags;
        }

        public String getPeriod1WakeupTime() {
            return period1WakeupTime;
        }

        public void setPeriod1WakeupTime(String period1WakeupTime) {
            this.period1WakeupTime = period1WakeupTime;
        }

        public String getPeriod1SleepTime() {
            return period1SleepTime;
        }

        public void setPeriod1SleepTime(String period1SleepTime) {
            this.period1SleepTime = period1SleepTime;
        }

        public String getPeriod2WakeupTime() {
            return period2WakeupTime;
        }

        public void setPeriod2WakeupTime(String period2WakeupTime) {
            this.period2WakeupTime = period2WakeupTime;
        }

        public String getPeriod2SleepTime() {
            return period2SleepTime;
        }

        public void setPeriod2SleepTime(String period2SleepTime) {
            this.period2SleepTime = period2SleepTime;
        }

        public String getPeriod3WakeupTime() {
            return period3WakeupTime;
        }

        public void setPeriod3WakeupTime(String period3WakeupTime) {
            this.period3WakeupTime = period3WakeupTime;
        }

        public String getPeriod3SleepTime() {
            return period3SleepTime;
        }

        public void setPeriod3SleepTime(String period3SleepTime) {
            this.period3SleepTime = period3SleepTime;
        }

        public String getPeriod4WakeupTime() {
            return period4WakeupTime;
        }

        public void setPeriod4WakeupTime(String period4WakeupTime) {
            this.period4WakeupTime = period4WakeupTime;
        }

        public String getPeriod4SleepTime() {
            return period4SleepTime;
        }

        public void setPeriod4SleepTime(String period4SleepTime) {
            this.period4SleepTime = period4SleepTime;
        }

        @Override
        public String toString() {
            return "DailyWakeupSetting{" +
                    "periodEnableFlags=" + periodEnableFlags +
                    ", period1WakeupTime='" + period1WakeupTime + '\'' +
                    ", period1SleepTime='" + period1SleepTime + '\'' +
                    ", period2WakeupTime='" + period2WakeupTime + '\'' +
                    ", period2SleepTime='" + period2SleepTime + '\'' +
                    ", period3WakeupTime='" + period3WakeupTime + '\'' +
                    ", period3SleepTime='" + period3SleepTime + '\'' +
                    ", period4WakeupTime='" + period4WakeupTime + '\'' +
                    ", period4SleepTime='" + period4SleepTime + '\'' +
                    '}';
        }
    }

    private byte wakeupMode;
    private byte wakeupConditions;
    private byte weeklyWakeupSetting;
    private DailyWakeupSetting dailyWakeupSetting;

    public byte getWakeupMode() {
        return wakeupMode;
    }

    public void setWakeupMode(byte wakeupMode) {
        this.wakeupMode = wakeupMode;
    }

    public byte getWakeupConditions() {
        return wakeupConditions;
    }

    public void setWakeupConditions(byte wakeupConditions) {
        this.wakeupConditions = wakeupConditions;
    }

    public byte getWeeklyWakeupSetting() {
        return weeklyWakeupSetting;
    }

    public void setWeeklyWakeupSetting(byte weeklyWakeupSetting) {
        this.weeklyWakeupSetting = weeklyWakeupSetting;
    }

    public DailyWakeupSetting getDailyWakeupSetting() {
        return dailyWakeupSetting;
    }

    public void setDailyWakeupSetting(DailyWakeupSetting dailyWakeupSetting) {
        this.dailyWakeupSetting = dailyWakeupSetting;
    }

    @Override
    public String toString() {
        return "TP_007C_SleepWakeupSettings{" +
                "wakeupMode=" + wakeupMode +
                ", wakeupConditions=" + wakeupConditions +
                ", weeklyWakeupSetting=" + weeklyWakeupSetting +
                ", dailyWakeupSetting=" + dailyWakeupSetting +
                '}';
    }
}
