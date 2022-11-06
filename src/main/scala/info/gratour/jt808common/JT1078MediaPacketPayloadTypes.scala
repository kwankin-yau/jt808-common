package info.gratour.jt808common

object JT1078MediaPacketPayloadTypes {

  case class MediaPacketPayloadType(typ: Int, typeName: String)

  final val G721_VALUE = 1
  final val G722_VALUE = 2
  final val G723_VALUE = 3
  final val G728_VALUE = 4
  final val G729_VALUE = 5
  final val G711A_VALUE = 6
  final val G711U_VALUE = 7
  final val G726_VALUE = 8
  final val G729A_VALUE = 9
  final val DVI4_3_VALUE = 10
  final val DVI4_4_VALUE = 11
  final val DVI4_8K_VALUE = 12
  final val DVI4_16K_VALUE = 13
  final val LPC_VALUE = 14
  final val S16BE_STEREO_VALUE = 15
  final val S16BE_MONO_VALUE = 16
  final val MPEGAUDIO_VALUE = 17
  final val LPCM_VALUE = 18
  final val AAC_VALUE = 19
  final val WMA9STD_VALUE = 20
  final val HEAAC_VALUE = 21
  final val PCM_VOICE_VALUE = 22
  final val PCM_AUDIO_VALUE = 23
  final val AACLC_VALUE = 24
  final val MP3_VALUE = 25
  final val ADPCMA_VALUE = 26
  final val MP4AUDIO_VALUE = 27
  final val AMR_VALUE = 28
  final val PASS_THROUGH_VALUE = 91
  final val H264_VALUE = 98
  final val H265_VALUE = 99
  final val AVS_VALUE = 100
  final val SVAC_VALUE = 101


  final val G721: MediaPacketPayloadType = MediaPacketPayloadType(G721_VALUE, "G.721 (1)")
  final val G722: MediaPacketPayloadType = MediaPacketPayloadType(G722_VALUE, "G.722 (2)")
  final val G723: MediaPacketPayloadType = MediaPacketPayloadType(G723_VALUE, "G.723 (3)")
  final val G728: MediaPacketPayloadType = MediaPacketPayloadType(G728_VALUE, "G.728 (4)")
  final val G729: MediaPacketPayloadType = MediaPacketPayloadType(G729_VALUE, "G.729 (5)")
  final val G711A: MediaPacketPayloadType = MediaPacketPayloadType(G711A_VALUE, "G.711A (6)")
  final val G711U: MediaPacketPayloadType = MediaPacketPayloadType(G711U_VALUE, "G.711U (7)")
  final val G726: MediaPacketPayloadType = MediaPacketPayloadType(G726_VALUE, "G.726 (8)")
  final val G729A: MediaPacketPayloadType = MediaPacketPayloadType(G729A_VALUE, "G.729A (9)")
  final val DVI4_3: MediaPacketPayloadType = MediaPacketPayloadType(DVI4_3_VALUE, "DVI4_3 (10)")
  final val DVI4_4: MediaPacketPayloadType = MediaPacketPayloadType(DVI4_4_VALUE, "DVI4_4 (11)")
  final val DVI4_8K: MediaPacketPayloadType = MediaPacketPayloadType(DVI4_8K_VALUE, "DVI4_8K (12)")
  final val DVI4_16K: MediaPacketPayloadType = MediaPacketPayloadType(DVI4_16K_VALUE, "DVI4_16K (13)")
  final val LPC: MediaPacketPayloadType = MediaPacketPayloadType(LPC_VALUE, "LPC (14)")
  final val S16BE_STEREO: MediaPacketPayloadType = MediaPacketPayloadType(S16BE_STEREO_VALUE, "S16BE_STEREO (15)")
  final val S16BE_MONO: MediaPacketPayloadType = MediaPacketPayloadType(S16BE_MONO_VALUE, "S16BE_MONO (16)")
  final val MPEGAUDIO: MediaPacketPayloadType = MediaPacketPayloadType(MPEGAUDIO_VALUE, "MPEGAUDIO (17)")
  final val LPCM: MediaPacketPayloadType = MediaPacketPayloadType(LPCM_VALUE, "LPCM (18)")
  final val AAC: MediaPacketPayloadType = MediaPacketPayloadType(AAC_VALUE, "AAC (19)")
  final val WMA9STD: MediaPacketPayloadType = MediaPacketPayloadType(WMA9STD_VALUE, "WMA9STD (20)")
  final val HEAAC: MediaPacketPayloadType = MediaPacketPayloadType(HEAAC_VALUE, "HEAAC (21)")
  final val PCM_VOICE: MediaPacketPayloadType = MediaPacketPayloadType(PCM_VOICE_VALUE, "PCM_VOICE (22)")
  final val PCM_AUDIO: MediaPacketPayloadType = MediaPacketPayloadType(PCM_AUDIO_VALUE, "PCM_AUDIO (23)")
  final val AACLC: MediaPacketPayloadType = MediaPacketPayloadType(AACLC_VALUE, "AACLC (24)")
  final val MP3: MediaPacketPayloadType = MediaPacketPayloadType(MP3_VALUE, "MP3 (25)")
  final val ADPCMA: MediaPacketPayloadType = MediaPacketPayloadType(ADPCMA_VALUE, "ADPCMA (26)")
  final val MP4AUDIO: MediaPacketPayloadType = MediaPacketPayloadType(MP4AUDIO_VALUE, "MP4AUDIO (27)")
  final val AMR: MediaPacketPayloadType = MediaPacketPayloadType(AMR_VALUE, "AMR (28)")
  final val PASS_THROUGH: MediaPacketPayloadType = MediaPacketPayloadType(PASS_THROUGH_VALUE, "Pass Through (91)")
  final val H264: MediaPacketPayloadType = MediaPacketPayloadType(H264_VALUE, "H264 (98)")
  final val H265: MediaPacketPayloadType = MediaPacketPayloadType(H265_VALUE, "H265 (99)")
  final val AVS: MediaPacketPayloadType = MediaPacketPayloadType(AVS_VALUE, "AVS (100)")
  final val SVAC: MediaPacketPayloadType = MediaPacketPayloadType(SVAC_VALUE, "SVAC (101)")

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
