package info.gratour.jt808common.protocol.msg.types;

import com.google.gson.Gson;
import info.gratour.jt808common.protocol.msg.types.ackparams.AckParamsParser$;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParamsParser;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CmdParamsParser$;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParamsParser;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

public class TermCmdParamsParser {

    public static final TermCmdParamsParser DEFAULT =
            new TermCmdParamsParser(CmdParamsParser$.MODULE$, AckParamsParser$.MODULE$);

    private final JT808CmdParamsParser cmdParamsParser;
    private final JT808AckParamsParser ackParamsParser;

    public TermCmdParamsParser(JT808CmdParamsParser cmdParamsParser, JT808AckParamsParser ackParamsParser) {
        this.cmdParamsParser = cmdParamsParser;
        this.ackParamsParser = ackParamsParser;
    }

    public JT808CmdParams cmdParamsFromJson(int msgId, String json, Gson gson) {
        return cmdParamsParser.fromJson(msgId, json, gson);
    }

    public JT808CmdParams cmdParamsFromJson(String msgIdHex, String json, Gson gson) {
        return cmdParamsFromJson(JTUtils.hexToMsgId(msgIdHex), json, gson);
    }

    public JT808CmdParams cmdParamsFromJson(int msgId, String json) {
        return cmdParamsFromJson(msgId, json, JTConsts.GSON());
    }

    public JT808CmdParams cmdParamsFromJson(String msgIdHex, String json) {
        return cmdParamsFromJson(msgIdHex, json, JTConsts.GSON());
    }


    public JT808AckParams ackParamsFromJsonBySrcMsgId(int srcMsgId, String json, Gson gson) {
        return ackParamsParser.fromJsonBySrcMsgId(srcMsgId, json, gson);
    }
    public JT808AckParams ackParamsFromJson(int ackMsgId, String json, Gson gson) {
        return ackParamsParser.fromJson(ackMsgId, json, gson);
    }

    public JT808AckParams ackParamsFromJsonBySrcMsgId(String srcMsgIdHex, String json, Gson gson) {
        return ackParamsFromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json, gson);
    }


    public JT808AckParams ackParamsFromJsonBySrcMsgId(int srcMsgId, String json) {
        return ackParamsFromJsonBySrcMsgId(srcMsgId, json, JTConsts.GSON());
    }


    public JT808AckParams ackParamsFromJsonBySrcMsgId(String srcMsgIdHex, String json) {
        return ackParamsFromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json);
    }

    public JT808AckParams ackParamsFromJson(String ackMsgIdHex, String json, Gson gson) {
        return ackParamsFromJson(JTUtils.hexToMsgId(ackMsgIdHex), json, gson);
    }

    public JT808AckParams ackParamsFromJson(int ackMsgId, String json) {
        return ackParamsFromJson(ackMsgId, json, JTConsts.GSON());
    }

    public JT808AckParams ackParamsFromJson(String ackMsgIdHex, String json) {
        return ackParamsFromJson(JTUtils.hexToMsgId(ackMsgIdHex), json);
    }

}
