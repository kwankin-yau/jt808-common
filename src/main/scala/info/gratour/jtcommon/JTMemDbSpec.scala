/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

object JTMemDbSpec {

  object SessionToken {
    val KeyPrefix = "s:"
    def key(token: String): String = KeyPrefix + token
  }

  object CurrAlm {
    val KeyPrefix = "calm:"
    def key(simNo: String, typ: String): String = KeyPrefix + simNo + ":" + typ
  }

  object VehCurrDrv {
    val KeyPrefix = "vcd:"
    def key(vehId: Long): String = KeyPrefix + vehId
  }

//  object AlmTm1Mapping {
//    val KeyPrefix = "almtm1:"
//    def key(almId: Long): String = KeyPrefix + almId
//  }

}
