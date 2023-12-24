package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.google.gson.Gson;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

public interface JT808AckParamsParser {

    JT808AckParams fromJsonBySrcMsgId(int srcMsgId, String json, Gson gson);
    JT808AckParams fromJson(int ackMsgId, String json, Gson gson);



    default JT808AckParams fromJsonBySrcMsgId(String srcMsgIdHex, String json, Gson gson) {
        return fromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json, gson);
    }


    default JT808AckParams fromJsonBySrcMsgId(int srcMsgId, String json) {
        return fromJsonBySrcMsgId(srcMsgId, json, JTConsts.GSON());
    }


    default JT808AckParams fromJsonBySrcMsgId(String srcMsgIdHex, String json) {
        return fromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json);
    }

    default JT808AckParams fromJson(String ackMsgIdHex, String json, Gson gson) {
        return fromJson(JTUtils.hexToMsgId(ackMsgIdHex), json, gson);
    }

    default JT808AckParams fromJson(int ackMsgId, String json) {
        return fromJson(ackMsgId, json, JTConsts.GSON());
    }

    default JT808AckParams fromJson(String ackMsgIdHex, String json) {
        return fromJson(JTUtils.hexToMsgId(ackMsgIdHex), json);
    }



}
