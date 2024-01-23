/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jt808common.adas;

/**
 * 平台ADAS报警类型定义。
 * <p>
 * 报警类型标识由4位HEX数字组成。其中第1、2个数字为报警类别，是报警上报时的附加ID值。
 * 如：高级驾驶辅助系统报警为 0x64，即 `64` 为高级驾驶辅助系统报警类别。
 */
public class AdasAlmTypes {

    /**
     * 高级驾驶辅助系统报警
     */
    public static class DrivingAssistAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "64";

        /**
         * 前向碰撞报警
         */
        public static final String FrontCrash = "6401";

        /**
         * 车道偏离报警
         */
        public static final String StrayPath = "6402";

        /**
         * 车距过近报警
         */
        public static final String TooCloseToFrontCar = "6403";

        /**
         * 行人碰撞报警
         */
        public static final String PedestrianHit = "6404";

        /**
         * 频繁变道报警
         */
        public static final String ChangeLaneFrequently = "6405";

        /**
         * 道路标识超限报警
         */
        public static final String RoadRecogMarkOverrun = "6406";

        /**
         * 障碍物报警
         */
        public static final String Obstacle = "6407";

        /**
         * 驾驶辅助功能失效报警
         */
        public static final String AssistFuncFailure = "6408";

        /**
         * 道路标志识别事件
         */
        public static final String RoadRecogEvent = "6410";

        /**
         * 主动抓拍识别事件
         */
        public static final String ActiveCaptureEvent = "6411";

        /**
         * 实线变道报警
         */
        public static final String ViolatedChangePath = "6412";

        /**
         * 车厢过道行人监测
         */
        public static final String PassengerAtCarriageHallwayDetected = "6413";

        /**
         * 设备失效提醒
         */
        public static final String DeviceFailure = "6414";

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "64FF";
    }

    /**
     * 驾驶员状态监测系统报警
     */
    public static class DriverBehavAlm {

        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "65";

        /**
         * 疲劳驾驶报警
         */
        public static final String Fatigued = "6501";

        /**
         * 接打手持电话报警
         */
        public static final String PhoneCall = "6502";

        /**
         * 抽烟报警报警
         */
        public static final String Smoke = "6503";

        /**
         * 长时间不目视前方报警
         */
        public static final String NoLookAhead = "6504";

        /**
         * 未检测到驾驶员报警
         */
        public static final String DriverNotDetected = "6505";

        /**
         * 双手同时脱离方向盘报警
         */
        public static final String SteeringWheelNotHolding = "6506";

        /**
         * 驾驶员行为监测功能失效报警
         */
        public static final String DriverBehavAlmFuncFailure = "6507";

        /**
         * 未系安全带报警
         */
        public static final String NotBelting = "6508";

        /**
         * 红外阻断型墨镜失效报警
         */
        public static final String AntiFaceRecogDetectFuncFailure = "650B";

        /**
         * 玩手机报警
         */
        public static final String PlaySmartPhone = "650D";

        /**
         * 夜间禁行报警
         */
        public static final String NightDriveProhibited = "650E";

        /**
         * 超时驾驶报警
         */
        public static final String DriveOvertime = "650F";

        /**
         * 自动抓拍事件
         */
        public static final String AutoCapture = "6510";

        /**
         * 驾驶员变更事件
         */
        public static final String DriverChangedEvent = "6511";

        /**
         * 驾驶员身份异常
         */
        public static final String InvalidDriverId = "6512";

        /**
         * 点火抓拍事件
         */
        public static final String IgnitedCapture = "6514";

        /**
         * 探头遮挡报警（粤标）
         */
        public static final String CameraCovered = "65F0";

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "65FF";
    }

    /**
     * 胎压监测系统报警
     */
    public static class TyreStateAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "66";
    }

    /**
     * 盲区监测系统报警
     */
    public static class BlindAreaAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "67";

        /**
         * 后方接近报警
         */
        public static final String RearTooClose = "6701";

        /**
         * 左侧后方接近报警
         */
        public static final String LeftRearTooClose = "6702";

        /**
         * 右侧后方接近报警
         */
        public static final String RightRearTooClose = "6703";

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "65FF";
    }

    /**
     * 激烈驾驶报警
     */
    public static class IntenseDrivingAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "70";

        /**
         * 急加速报警
         */
        public static final String RapidAccelerate = "7001";

        /**
         * 急减速报警
         */
        public static final String RapidDecelerate = "7002";

        /**
         * 急转弯报警
         */
        public static final String RapidTurn = "7003";

        /**
         * 怠速报警
         */
        public static final String Idling = "7004";

        /**
         * 异常熄火报警
         */
        public static final String UnexpectedFlameOut = "7005";

        /**
         * 空挡滑行报警
         */
        public static final String SlidingOnN = "7006";

        /**
         * 发动机超转报警
         */
        public static final String EngineRpmTooHigh = "7007";

        /**
         * 不能识别或厂商自定义报警/事件类型
         */
        public static final String CUSTOM = "65FF";
    }

    /**
     * 卫星定位超速报警
     */
    public static class OverSpdAlm {
        /**
         * 类别ID
         */
        public static final String CATEGORY_ID = "71";
    }
}
