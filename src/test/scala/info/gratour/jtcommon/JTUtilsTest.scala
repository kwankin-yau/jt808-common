/** *****************************************************************************
 * Copyright (c) 2019, 2021 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ***************************************************************************** */
package info.gratour.jtcommon

object JTUtilsTest {

  def main(args: Array[String]): Unit = {
    assert(JTUtils.normalizeSimNo("00000000013305189341") == "13305189341")
  }
}
