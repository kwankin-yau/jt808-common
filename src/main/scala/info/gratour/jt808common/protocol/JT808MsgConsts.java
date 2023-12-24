package info.gratour.jt808common.protocol;

public class JT808MsgConsts {

    /**
     * 设备通用应答
     */
    public static final int TERMINAL_GENERIC_ACK_0001 = 0x0001;

    /**
     * 终端心跳
     */
    public static final int HEARTBEAT_0002 = 0x0002;

    /**
     * 平台通用应答
     */
    public static final int SERVER_GENERIC_ACK_8001 = 0x8001;


    /**
     * 补传分包请求。注意：此消息也可平台发送，也可设备发送。主要用于分包消息未能完整接收的情况，一般为UDP链路。
     */
    public static final int PACKET_RETRANSMIT_REQ_8003 = 0x8003;


    /**
     * 终端注销
     */
    public static final int TERMINAL_UNREGISTER_0003 = 0x0003;

    /**
     * 查询服务器时间
     *
     * @since REV_2019
     */
    public static final int QRY_SERVER_TIME_0004 = 0x0004;

    /**
     * 查询服务器时间应答
     *
     * @since REV_2019
     */
    public static final int QRY_SERVER_TIME_ACK_8004 = 0x8004;

    /**
     * 终端注册应答
     */
    public static final int TERMINAL_REGISTER_ACK_8100 = 0x8100;

    /**
     * 终端注册
     */
    public static final int TERMINAL_REGISTER_0100 = 0x0100;
    public static final String HEX_MSG_ID__TERMINAL_REGISTER_0100 = "0100";

    /**
     * 终端鉴权
     */
    public static final int TERMINAL_AUTH_0102 = 0x0102;

    /**
     * 设置终端参数
     */
    public static final int SET_PARAMS_8103 =  0x8103;

    /**
     * 查询终端所有参数
     */
    public static final int QRY_ALL_PARAMS_8104 =  0x8104;

    /**
     * 查询终端参数应答
     */
    public static final int QRY_PARAMS_ACK_0104 = 0x0104;

    /**
     * 终端控制
     */
    public static final int TERMINAL_CTRL_8105 = 0x8105;
    public static final String HEX_MSG_ID__TERMINAL_CTRL_8105 = "8105";

    /**
     * 查询指定终端参数
     */
    public static final int QRY_SPECIAL_PARAMS_8106 =  0x8106;


    /**
     * 查询终端属性
     */
    public static final int QRY_TERMINAL_ATTRS_8107 = 0x8107;
    public static final String HEX_MSG_ID__QRY_TERMINAL_ATTRS_8107 = "8107";

    /**
     * 查询终端属性应答
     */
    public static final int QRY_TERMINAL_ATTRS_ACK_0107 = 0x0107;
    public static final String HEX_MSG_ID__QRY_TERMINAL_ATTRS_ACK_0107 = "0107";

    /**
     * 下发终端升级包
     */
    public static final int UPGRADE_PACKET_8108 = 0x8108;

    /**
     * 终端升级结果通知
     */
    public static final int UPGRADE_RESULT_0108 = 0x0108;

    /**
     * 位置上报
     */
    public static final int LOCATION_0200 = 0x0200;
    public static final String HEX_MSG_ID__LOCATION_0200 = "0200";

    /**
     * 位置信息查询
     */
    public static final int QRY_LOCATION_8201 =  0x8201;

    /**
     * 位置信息查询应答
     */
    public static final int QRY_LOCATION_ACK_0201 = 0x0201;
    public static final String HEX_MSG_ID__QRY_LOCATION_ACK_0201 = "0201";

    /**
     * 临时位置跟踪控制
     */
    public static final int LOCATION_TRACE_CTRL_8202 =  0x8202;

    /**
     * 人工确认报警消息
     */
    public static final int MANUAL_CONFIRM_ALARM_8203 =  0x8203;

    /**
     * 文本信息下发
     */
    public static final int SEND_TEXT_8300 =  0x8300;
    public static final String HEX_MSG_ID__SEND_TEXT_8300 = "8300";

    /**
     * 事件设置
     */
    public static final int SET_UP_EVENT_8301 = 0x8301;

    /**
     * 提问下发
     */
    public static final int INQUEST_8302 = 0x8302;

    /**
     * 信息点播菜单设置
     */
    public static final int SET_UP_INFO_MENU_8303 = 0x8303;

    /**
     * 事件报告
     */
    public static final int EVENT_REPORT_0301 =  0x0301;

    /**
     * 提问应答
     */
    public static final int INQUEST_ANSWER_0302 =  0x0302;

    /**
     * 信息点播/取消
     */
    public static final int INFO_DEMAND_0303 =  0x0303;

    /**
     * 信息服务
     */
    public static final int INFO_SERVICE_8304 = 0x8304;

    /**
     * 电话回拨
     */
    public static final int PHONE_CALLBACK_8400 = 0x8400;
    public static final String HEX_MSG_ID__PHONE_CALLBACK_8400 = "8400";

    /**
     * 设置电话本
     */
    public static final int SET_UP_PHONE_BOOK_8401 = 0x8401;

    /**
     * 车辆控制
     */
    public static final int VEH_CTRL_8500 =  0x8500;

    /**
     * 车辆控制应答
     */
    public static final int VEH_CTRL_ACK_0500 =  0x0500;

    /**
     * 设置圆形区域
     */
    public static final int SET_CIRCLE_REGION_8600 = 0x8600;

    /**
     * 删除圆形区域
     */
    public static final int DEL_CIRCLE_REGION_8601 = 0x8601;

    /**
     * 设置矩形区域
     */
    public static final int SET_RECT_REGION_8602 = 0x8602;

    /**
     * 删除矩形区域
     */
    public static final int DEL_RECT_REGION_8603 = 0x8603;

    /**
     * 设置多边形区域
     */
    public static final int SET_POLYGON_REGION_8604 = 0x8604;

    /**
     * 删除多边形区域
     */
    public static final int DEL_POLYGON_REGION_8605 = 0x8605;

    /**
     * 设置路线
     */
    public static final int SET_ROUTE_8606 = 0x8606;

    /**
     * 删除路线
     */
    public static final int DEL_ROUTE_8607 = 0x8607;

    /**
     * 行驶记录数据采集命令
     */
    public static final int VTDR_DATA_COLLECT_REQ_8700 = 0x8700;
    public static final String HEX_MSG_ID__VTDR_DATA_COLLECT_REQ_8700 = "8700";

    /**
     * 行驶记录数据上传
     */
    public static final int VTDR_DATA_0700 =  0x0700;

    /**
     * 行驶记录参数下传命令
     */
    public static final int VTDR_SET_PARAMS_8701 = 0x8701;

    /**
     * 电子运单
     */
    public static final int WAYBILL_0701 =  0x0701;

    /**
     * 上报驾驶员身份信息请求
     */
    public static final int DRIVER_IDENTITY_REQ_8702 = 0x8702;

    /**
     * 驾驶员身份信息采集上报
     */
    public static final int DRIVER_IDENTITY_0702 =  0x0702;
    public static final String HEX_MSG_ID__DRIVER_IDENTITY_0702 = "0702";

    /**
     * 定位数据批量上传
     */
    public static final int BATCH_LOCATION_0704 =  0x0704;
    public static final String HEX_MSG_ID__BATCH_LOCATION_0704 = "0704";

    /**
     * CAN总线数据上传
     */
    public static final int CAN_DATA_0705 =  0x0705;

    /**
     * 多媒体数据上传
     */
    public static final int MULTI_MEDIA_DATA_0801 = 0x0801;
    public static final String HEX_MSG_ID__MULTI_MEDIA_DATA_0801 = "0801";

    /**
     * 多媒体事件信息上传
     */
    public static final int MULTI_MEDIA_EVENT_0800 =  0x0800;

    /**
     * 多媒体数据上传应答
     */
    public static final int MULTI_MEDIA_DATA_ACK_8800 =  0x8800;

    /**
     * 摄像头立即拍摄命令
     */
    public static final int TAKE_PHOTO_8801 =  0x8801;
    public static final String HEX_MSG_ID__TAKE_PHOTO_8801 = "8801";

    /**
     * 存储多媒体数据检索
     */
    public static final int STORED_MEDIA_SEARCH_8802 = 0x8802;

    /**
     * 存储多媒体数据检索应答
     */
    public static final int STORED_MEDIA_SEARCH_ACK_0802 = 0x0802;

    /**
     * 存储多媒体数据上传命令
     */
    public static final int STORED_MEDIA_REQ_8803 = 0x8803;

    /**
     * 录音开始命令
     */
    public static final int AUDIO_RECORD_CTRL_8804 = 0x8804;

    /**
     * 单条存储多媒体数据检索上传命令
     */
    public static final int SINGLE_STORED_MEDIA_REQ_8805 = 0x8805;

    /**
     * 摄像头立即拍摄命令应答
     */
    public static final int TAKE_PHOTO_ACK_0805 = 0x0805;

    /**
     * 数据下行透传
     */
    public static final int PASS_THROUGH_DATA_DL_8900 = 0x8900;

    /**
     * 数据上行透传
     */
    public static final int PASS_THROUGH_DATA_UL_0900 = 0x0900;

    /**
     * 数据压缩上报
     */
    public static final int COMPRESSED_DATA_UL_0x0901 = 0x0901;

    /**
     * 平台 RSA 公钥
     */
    public static final int PLATFORM_RSA_KEY_8A00 = 0x8A00;

    /**
     * 终端RSA 公钥
     */
    public static final int TERMINAL_RSA_KEY_0x0A00 = 0x0A00;


    public static boolean isPlatformAck(int msgId) {
        switch (msgId) {
            case SERVER_GENERIC_ACK_8001:
            case QRY_SERVER_TIME_ACK_8004:
            case TERMINAL_REGISTER_ACK_8100:
            case MULTI_MEDIA_DATA_ACK_8800:
                return true;

            default:
                return false;
        }
    }
}
