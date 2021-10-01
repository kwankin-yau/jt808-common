package info.gratour.jt808common.codec.encoder

import info.gratour.jt808common.codec.encoder.impl.{MBEncoderAdas_1210_FileList, MBEncoderAdas_1211_FileItem, MBEncoderAdas_1212_FileItemCompleted, MBEncoderAdas_9208_AlarmAttUploadReq, MBEncoderAdas_9212_AlarmAttFileItemCompleted}

object JT808MsgBodyEncoderRegistry_Adas extends JT808MsgBodyEncoderRegistry {

  private[encoder] val AdasEncoderMap: Map[Int, JT808MsgBodyEncoder] = mapOf(
    Seq(
      // Adas - terminal
      MBEncoderAdas_1210_FileList,
      MBEncoderAdas_1211_FileItem,
      MBEncoderAdas_1212_FileItemCompleted,

      // Adas - platform
      MBEncoderAdas_9208_AlarmAttUploadReq,
      MBEncoderAdas_9212_AlarmAttFileItemCompleted
    )
  )

  private[encoder] val map: Map[Int, JT808MsgBodyEncoder] = JT808MsgBodyEncoderRegistry_Rev2013.map ++ AdasEncoderMap

  override def get(msgId: Int): JT808MsgBodyEncoder = map.getOrElse(msgId, null)


}
