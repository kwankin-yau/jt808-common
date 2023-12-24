/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jt808common.mat

import java.lang.reflect.Type

import com.google.gson._
import info.gratour.jt808common.protocol.msg.types.ackparams.AckParamsParser
import info.gratour.jt808common.protocol.msg.types.cmdparams.CmdParamsParser
import info.gratour.jt808common.spi.model.TermCmd
import info.gratour.jtcommon.JTConsts

class TermCmdMaterializer extends JsonSerializer[TermCmd] with JsonDeserializer[TermCmd] {
  override def serialize(src: TermCmd, typeOfSrc: Type, context: JsonSerializationContext): JsonElement = {
    val obj = new JsonObject

    var s = src.getAppId
    if (s != null)
      obj.addProperty("appId", s)

    s = src.getId
    if (s != null)
      obj.addProperty("id", s)

    s = src.getExternalId
    if (s != null)
      obj.addProperty("externalId", s)

    s = src.getMsgId
    if (s != null)
      obj.addProperty("msgId", s)

    s = src.getSubCmdTyp
    if (s != null)
      obj.addProperty("subCmdType", s)

    s = src.getSimNo
    if (s != null)
      obj.addProperty("simNo", s)

    s = src.getReqId
    if (s != null)
      obj.addProperty("reqId", s)

    s = src.getPlateNo
    if (s != null)
      obj.addProperty("plateNo", s)

    var i = src.getPlateColor
    if (i != null)
      obj.addProperty("plateColor", i)

    obj.addProperty("reqTm", src.getReqTm)

    obj.addProperty("sentTm", src.getSentTm)

    var l = src.getAckTm
    if (l != null)
      obj.addProperty("ackTm", l)

    l = src.getEndTm
    if (l != null)
      obj.addProperty("endTm", l)

    obj.addProperty("status", src.getStatus)

    i = src.getMsgSn
    if (i != null)
      obj.addProperty("msgSn", i)

    i = src.getAckCode
    if (i != null)
      obj.addProperty("ackCode", i)

    val params = src.getParams
    if (params != null)
      obj.add("params", context.serialize(params))

    val ackParams = src.getAckParams
    if (ackParams != null)
      obj.add("ackParams", context.serialize(ackParams))

    obj
  }

  override def deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TermCmd = {
    val r = new TermCmd
    val obj = json.asInstanceOf[JsonObject]

    if (obj.has("appId"))
      r.setAppId(obj.getAsJsonPrimitive("appId").getAsString)

    if (obj.has("id"))
      r.setId(obj.getAsJsonPrimitive("id").getAsString)

    if (obj.has("externalId"))
      r.setExternalId(obj.getAsJsonPrimitive("externalId").getAsString)

    if (obj.has("msgId"))
      r.setMsgId(obj.getAsJsonPrimitive("msgId").getAsString)

    if (obj.has("subCmdType"))
      r.setSubCmdTyp(obj.getAsJsonPrimitive("subCmdType").getAsString)

    if (obj.has("simNo"))
      r.setSimNo(obj.getAsJsonPrimitive("simNo").getAsString)

    if (obj.has("reqId"))
      r.setReqId(obj.getAsJsonPrimitive("reqId").getAsString)

    if (obj.has("plateNo"))
      r.setPlateNo(obj.getAsJsonPrimitive("plateNo").getAsString)

    if (obj.has("plateColor"))
      r.setPlateColor(obj.getAsJsonPrimitive("plateColor").getAsInt)

    if (obj.has("reqTm"))
      r.setReqTm(obj.getAsJsonPrimitive("reqTm").getAsLong)

    if (obj.has("sentTm"))
      r.setSentTm(obj.getAsJsonPrimitive("sentTm").getAsLong)

    if (obj.has("ackTm"))
      r.setAckTm(obj.getAsJsonPrimitive("ackTm").getAsLong)

    if (obj.has("endTm"))
      r.setEndTm(obj.getAsJsonPrimitive("endTm").getAsLong)

    if (obj.has("status"))
      r.setStatus(obj.getAsJsonPrimitive("status").getAsInt)

    if (obj.has("msgSn"))
      r.setMsgSn(obj.getAsJsonPrimitive("msgSn").getAsInt)

    if (obj.has("ackCode"))
      r.setAckCode(obj.getAsJsonPrimitive("ackCode").getAsInt)

    if (obj.has("params")) {
      val json = obj.getAsJsonObject("params")
      val s = JTConsts.SIMPLE_GSON.toJson(json)
      r.setParams(CmdParamsParser.fromJson(r.jtMsgId(), s))
    }

    if (obj.has("ackParams")) {
      val json = obj.getAsJsonObject("ackParams")
      val s = JTConsts.SIMPLE_GSON.toJson(json)
      r.setAckParams(AckParamsParser.fromJsonBySrcMsgId(r.jtMsgId(), s))
    }

    r
  }
}
