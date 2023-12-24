package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.google.gson.Gson;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

public interface JT808CmdParamsParser {

    JT808CmdParams fromJson(int msgId, String json, Gson gson);

    default JT808CmdParams fromJson(String msgIdHex, String json, Gson gson) {
        return fromJson(JTUtils.hexToMsgId(msgIdHex), json, gson);
    }


    default JT808CmdParams fromJson(int msgId, String json) {
        return fromJson(msgId, json, JTConsts.GSON());
    }


    default JT808CmdParams fromJson(String msgIdHex, String json) {
        return fromJson(JTUtils.hexToMsgId(msgIdHex), json);
    }

}
