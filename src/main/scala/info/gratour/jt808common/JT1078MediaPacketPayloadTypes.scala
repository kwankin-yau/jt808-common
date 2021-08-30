package info.gratour.jt808common

object JT1078MediaPacketPayloadTypes {

  case class MediaPacketPayloadType(typ: Int, typeName: String)

  val G721: MediaPacketPayloadType = MediaPacketPayloadType(1, "G.721 (1)")
  val G722: MediaPacketPayloadType = MediaPacketPayloadType(2, "G.722 (2)")
  val G723: MediaPacketPayloadType = MediaPacketPayloadType(3, "G.723 (3)")
  val G728: MediaPacketPayloadType = MediaPacketPayloadType(4, "G.728 (4)")
  val G729: MediaPacketPayloadType = MediaPacketPayloadType(5, "G.729 (5)")
  val G711A: MediaPacketPayloadType = MediaPacketPayloadType(6, "G.711A (6)")
  val G711U: MediaPacketPayloadType = MediaPacketPayloadType(7, "G.711U (7)")
  val G726: MediaPacketPayloadType = MediaPacketPayloadType(8, "G.726 (8)")
  val G729A: MediaPacketPayloadType = MediaPacketPayloadType(9, "G.729A (9)")
  val DVI4_3: MediaPacketPayloadType = MediaPacketPayloadType(10, "DVI4_3 (10)")
  val DVI4_4: MediaPacketPayloadType = MediaPacketPayloadType(11, "DVI4_4 (11)")
  val DVI4_8K: MediaPacketPayloadType = MediaPacketPayloadType(12, "DVI4_8K (12)")
  val DVI4_16K: MediaPacketPayloadType = MediaPacketPayloadType(13, "DVI4_16K (13)")
  val LPC: MediaPacketPayloadType = MediaPacketPayloadType(14, "LPC (14)")
  val S16BE_STEREO: MediaPacketPayloadType = MediaPacketPayloadType(15, "S16BE_STEREO (15)")
  val S16BE_MONO: MediaPacketPayloadType = MediaPacketPayloadType(16, "S16BE_MONO (16)")
  val MPEGAUDIO: MediaPacketPayloadType = MediaPacketPayloadType(17, "MPEGAUDIO (17)")
  val LPCM: MediaPacketPayloadType = MediaPacketPayloadType(18, "LPCM (18)")
  val AAC: MediaPacketPayloadType = MediaPacketPayloadType(19, "AAC (19)")
  val WMA9STD: MediaPacketPayloadType = MediaPacketPayloadType(20, "WMA9STD (20)")
  val HEAAC: MediaPacketPayloadType = MediaPacketPayloadType(21, "HEAAC (21)")
  val PCM_VOICE: MediaPacketPayloadType = MediaPacketPayloadType(22, "PCM_VOICE (22)")
  val PCM_AUDIO: MediaPacketPayloadType = MediaPacketPayloadType(23, "PCM_AUDIO (23)")
  val AACLC: MediaPacketPayloadType = MediaPacketPayloadType(24, "AACLC (24)")
  val MP3: MediaPacketPayloadType = MediaPacketPayloadType(25, "MP3 (25)")
  val ADPCMA: MediaPacketPayloadType = MediaPacketPayloadType(26, "ADPCMA (26)")
  val MP4AUDIO: MediaPacketPayloadType = MediaPacketPayloadType(27, "MP4AUDIO (27)")
  val AMR: MediaPacketPayloadType = MediaPacketPayloadType(28, "AMR (28)")
  val PASS_THROUGH: MediaPacketPayloadType = MediaPacketPayloadType(91, "Pass Through (91)")
  val H264: MediaPacketPayloadType = MediaPacketPayloadType(98, "H264 (98)")
  val H265: MediaPacketPayloadType = MediaPacketPayloadType(99, "H265 (99)")
  val AVS: MediaPacketPayloadType = MediaPacketPayloadType(100, "AVS (100)")
  val SVAC: MediaPacketPayloadType = MediaPacketPayloadType(101, "SVAC (101)")

  val Types: Map[Int, String] = Seq(
    G721,
    G722,
    G723,
    G728,
    G729,
    G711A,
    G711U,
    G726,
    G729A,
    DVI4_3,
    DVI4_4,
    DVI4_8K,
    DVI4_16K,
    LPC,
    S16BE_STEREO,
    S16BE_MONO,
    MP4AUDIO,
    LPCM,
    AAC,
    WMA9STD,
    HEAAC,
    PCM_VOICE,
    PCM_AUDIO,
    AACLC,
    MP3,
    ADPCMA,
    MP4AUDIO,
    AMR,
    PASS_THROUGH,
    H264,
    H265,
    AVS,
    SVAC
  ).map(t => t.typ -> t.typeName).toMap

  def typeNameOf(typ: Int): String =
    Types.getOrElse(typ, typ.toString)
}
