/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

import info.gratour.jt808common.JT808Consts
import info.gratour.jt808common.codec.CodecError

trait JTCodecHelper {

  val PROTO_VER__REV2013: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2013
  val PROTO_VER__REV2019: Byte = JT808Consts.ProtocolVersions.PROTO_VER__REV2019

  def notSupportedDataType(dataType: Int): CodecError = new CodecError(s"Not supported data type: $dataType.")
  def notSupportedMsgType(msgType: Class[_]): CodecError = new CodecError(s"Not supported message type: ${msgType.getName}.")

  def intAxisToDouble(axis: Int): Double = JTUtils.intAxisToDouble(axis)

  def doubleAxisToInt(axis: Double): Int = JTUtils.doubleAxisToInt(axis)

  protected def checkNotNull[A](o: A, propName: String): A = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")

    o
  }

  protected def checkNotEmpty[A](o: Array[A], propName: String): Array[A] = {
    if (o == null)
      throw new CodecError(s"`$propName` == null")
    if (o.isEmpty)
      throw new CodecError(s"`$propName` is empty")

    o
  }



}
