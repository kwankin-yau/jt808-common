package info.gratour.jtcommon

import java.util.{Locale, ResourceBundle}

object JTMessages {

  def resourceBundle(locale: Locale): ResourceBundle =
    ResourceBundle.getBundle("info.gratour.jt808common.jt-common", if (locale != null) locale else Locale.getDefault)

  def get(key: String, locale: Locale): String = resourceBundle(locale).getString(key)

  def unknown(locale: Locale): String = get("msg.unknown", locale);


  object PlateColors {
    val BLUE: Short = 1
    val YELLOW: Short = 2
    val BLACK: Short = 3
    val WHITE: Short = 4
    val GREEN: Short = 5
    val OTHER: Short = 9
    val AGR_YELLOW: Short = 91
    val AGR_GREEN: Short = 92
    val GREEN_GRADIENT: Short = 94

    val MESSAGE_KEY__BLUE = "plateColor.blue.1"
    val MESSAGE_KEY__YELLOW = "plateColor.yellow.2"
    val MESSAGE_KEY__BLACK = "plateColor.black.3"
    val MESSAGE_KEY__WHITE = "plateColor.white.4"
    val MESSAGE_KEY__GREEN = "plateColor.green.5"
    val MESSAGE_KEY__OTHER = "plateColor.other.9"
    val MESSAGE_KEY__AGR_YELLOW = "plateColor.agr_yellow.91"
    val MESSAGE_KEY__AGR_GREEN = "plateColor.agr_green.92"
    val MESSAGE_KEY__GREEN_GRADIENT = "plateColor.green_gradient.94"


    private def messageKey(plateColor: Int): String = plateColor match {
      case BLUE =>
        MESSAGE_KEY__BLUE
      case YELLOW =>
        MESSAGE_KEY__YELLOW
      case BLACK =>
        MESSAGE_KEY__BLACK
      case WHITE =>
        MESSAGE_KEY__WHITE
      case GREEN =>
        MESSAGE_KEY__GREEN
      case AGR_YELLOW =>
        MESSAGE_KEY__AGR_YELLOW
      case AGR_GREEN =>
        MESSAGE_KEY__AGR_GREEN
      case GREEN_GRADIENT =>
        MESSAGE_KEY__GREEN_GRADIENT
      case _ =>
        MESSAGE_KEY__OTHER
    }

    def toText(plateColor: Int, locale: Locale): String = {
      val key = messageKey(plateColor)
      get(key, locale)
    }

    def toText(plateColor: Number, locale: Locale): String = {
      if (plateColor == null)
        return "";

      val key = messageKey(plateColor.intValue())
      get(key, locale)
    }
  }

}
