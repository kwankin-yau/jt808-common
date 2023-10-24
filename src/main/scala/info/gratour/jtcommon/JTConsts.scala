package info.gratour.jtcommon

import java.nio.charset.Charset
import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZoneOffset}
import com.google.gson.{Gson, GsonBuilder}
import info.gratour.jt808common.mat.{TermCmdMaterializer, TermCmdStateChangedMaterializer}
import info.gratour.jt808common.spi.model.{TermCmd, TermCmdStateChanged}

object JTConsts {

  /**
   * @deprecated using info.gratour.jt808common.JT808Consts.ProtocolVersions#PROTO_VER_\_REV2013 instead
   */
  final val PROTO_VER__REV2013: Byte = 0

  /**
   * @deprecated using info.gratour.jt808common.JT808Consts.ProtocolVersions#PROTO_VER_\_REV2019 instead
   */
  final val PROTO_VER__REV2019: Byte = 1


  final val CHARSET_GBK: Charset = Charset.forName("GBK")
  final val DEFAULT_CHARSET: Charset = CHARSET_GBK

  final val ZONE_ID_Z: ZoneId = ZoneId.of("Z")

  final val ZONE_OFFSET_BEIJING: ZoneOffset = ZoneOffset.ofHours(8)

  final val ZERO_BYTE_ARRAY_32: Array[Byte] = Array.fill(32)(0)

  final val BCD_DATE_TIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss")
  final val CONVENIENT_DATETIME_FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  final val SIMPLE_GSON: Gson = new Gson();

  def GSON_BUILDER: GsonBuilder = new GsonBuilder()
//    .registerTypeAdapter(classOf[EpochMillis], new EpochMillisMaterializer)
    .registerTypeAdapter(classOf[TermCmd], new TermCmdMaterializer)
    .registerTypeAdapter(classOf[TermCmdStateChanged], new TermCmdStateChangedMaterializer)
//    .registerTypeAdapter(classOf[CP_8105_TerminalCtrl], new CPTerminalCtrlMaterializer)
//    .registerTypeAdapter(classOf[CmdAck], new CmdAckMaterializer)
//    .registerTypeAdapter(classOf[Event], new EventMaterializer)
//    .registerTypeAdapter(classOf[WrappedAlmRptCreate], new WrappedAlmRptCreateSerializer)
//    .registerTypeAdapter(classOf[WrappedAlmRptClose], new WrappedAlmRptCloseSerializer)
//    .registerTypeAdapter(classOf[GovSubmitMsg], new GovSubmitMaterializer)
//    .registerTypeAdapter(classOf[GovIssueMsg], new GovIssueMaterializer)
//    .registerTypeAdapter(classOf[GovIssueAckMsg], new GovIssueAckMaterializer)
//    .registerTypeAdapter(classOf[GatewayReq], new GatewayReqMaterializer)
//    .registerTypeAdapter(classOf[GatewayResp], new GatewayRespMaterializer)
//    .registerTypeAdapter(classOf[RtRgnChange], new RtRgnChangeMaterializer)
//

  final val GSON: Gson = GSON_BUILDER.create()
  final val GSON_PRETTY: Gson = GSON_BUILDER.setPrettyPrinting().create()
}
