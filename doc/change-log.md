# 3.1.0 - [2023-11-28]
## 完善
- 引用 GNSS 驱动
- `JT808Msg` 增加 `headers` 属性
- `JT808Frame` 改为只读对象，并增加 `backOffReader` 属性
- `TermCmdStateChanged` 增加 `uuid`, `pub` 属性, `setRandomUuid` 方法
- 新增 `info.gratour.jt808common.adas.AdasAlmTypes` 平台ADAS报警类型定义类
- `MQEventAddt_0800_MultiMediaEvent` 新增 MEDIA_TYPE__xxxx, MEDIA_FMT__xxxx, EVT_TYPE__xxxx 等常量定义.
- 新增 `MBEncoder808_Track.encodeTrackBasicInfo` 方法
- 新增 `MBEncoder808_0800_MultiMediaEvent`, `MBEncoder808_0801_MultiMediaData` 两个消息体编码器

## 变更
- `info.gratour.jt808common.spi.model.Event` 的 `protoVer` 属性改为 `String` 类型

# 3.0.0 - [2023-11-28]
## Improvement
- `TermCmd`:
  - add `externalId`, `senderToken`, `ackMsgId`, `ackSeqNo`, `pub` properties.
- `TermCmdStateChanged`:
  - add `appId`, `externalId`, `reqId` properties.
- Introduce `JT808CmdParamsParser`, `JT808AckParamsParser` interfaces.
- Introduce `TermCmdParamsParser`
- Introduce `MBEncoder808_0107_QryAttrsAck`
- Introduce `LazyBytesProvider`

## Changed
- Maven group changed to `com.lucendar`

## Fixed
- AckParams object are not direct implement Cloneable interface, cause the call of super.clone() 
  throws `CloneNotSupportedException`. 

# 2.0.4 - [2023-10-24]
## Improvement
- `TermCmd` add the following properties/methods:
    - `reqId`: the `reqId` of stream open request if the command is associated with an open stream request.
    - `getStatusString()` static method.
- Add many name shorten methods to JT1078 related message objects
- Introduce `ByteBufBackOffReader`

# 2.0.3 - [2023-07-01]
## Improvement
- `JT1078MediaPacketPayloadType` add enumName
- `info.gratour.jt808common.JT1078MediaPacketPayloadTypes.typeOfEnumName` added
- Introduce `JT1078TermAvAttrs`, and let `JT1078AckParams_1003_QryAvAttrsAck` inherited from it.
- Add missing `MBDecoder1078_9003_QryAvAttrs`
- `TermCmd` add `appId` property.
- Add `AdasOverloadAlmAddt`, `AdasOverHeightAlmAddt`
- `AdasDriverBehavAlmAddt`, `AdasDrivingAssistAlmAddt` add `typ2` property used to store the common defined alarm type ID.

# 2.0.2 - [2023-05-16]
## Fixed
- Memory leak in `info.gratour.jt808common.codec.decoder.JT808FramesCollector.collect` when the total count or index of
split info is invalid.
- Memory leak in `info.gratour.jt808common.codec.decoder.JT808Decoder.frameRecv`
- Memory leak in `info.gratour.jt808common.codec.decoder.JT808FramesCollector.collect` when receive duplicate fragment
- `NettyTimerProvider` should use shared HashedWheelTimer

## Improvement
- `info.gratour.jt808common.codec.decoder.JT808FrameDecoder.decodeFrame` introduce an optional parameter: `verifyCrc`.
- `info.gratour.jt808common.codec.decoder.JT808FrameDecoder.verifyCrc` check frame size before verify CRC
- `info.gratour.jt808common.codec.decoder.JT808FramesCollector.buildWholePacket` optimized
- Introduce simplified messages and decoders(for 0800, 0801 messages)

# 2.0.1 - [2022-10-19]
## Improvement
- `FileRepository` is belongs `jt808-common` now, which is moved from `jt808-core`
- Constants defined in `JTConsts` are defined as `final` now
- `info.gratour.jt808common.JT808Consts.ProtocolVersions.isValidProtoVer` added

## Fixed
- Memory leak in JT808FrameDecoder.close()
- info.gratour.jt808common.spi.model.TermCmd.isAckOrCompletedStatus() add `CMD_STATUS__EXCEPTION` case handling
- `info.gratour.jt808common.protocol.msg.types.trk.Trk.toCoordinate` method introduced.

## Changed
Bump some library for known vulnerable:
- Bump `scala-library` from `2.13.8` to `2.13.10` for: 
  - CVE-2022-36944 9.8 Deserialization of Untrusted Data vulnerability with high severity found
- Bump `netty-all` from `4.1.74-Final` to `4.1.77-Final` for:
  - CVE-2022-24823 5.5 Exposure of Resource to Wrong Sphere vulnerability pending CVSS allocation
- Bump `commons-valiator` from `1.6` to `1.7` for:
  - CVE-2019-10086 7.3 Deserialization of Untrusted Data vulnerability pending CVSS allocation
  - CVE-2014-0114 7.5 Improper Input Validation vulnerability pending CVSS allocation


# 2.0.0 - [2022-03-15]
## Improvement
- `0100`, `0102` message encoder added
- Added AdasAiRecogAlmAddt (db43)


## Changed
- Introduce `AdasDialect`
- Removed `JT808ProtocolVariant`, use protoVer and AdasDialect instead.
- Dependencies:
  - Bump `scala-library` FROM `2.13.6` to `2.13.8`
  - Bump `netty-all` FROM `4.1.72` to `4.1.74`

# 1.0.4 - [2022-04-16]
## Improvement
- `NettyUtils.decodeLenPrefixedString(ByteBuf buf, boolean trimTrailingNullChar)` added
- `info.gratour.jt808common.codec.decoder.JT808FrameDecoder.decodeFrame` add whole frame length check
- `0100`, `0102` message encoder added  

# 1.0.3 - [2022-01-22]
## Improvement
- `CmdAck` add `reqTm` property
- Introduce `TermCmdStateChanged` message and `TermCmdStateChangeMaterializer`
- Added `TermCmd.CMD_STATUS__TIMEOUT`, `TermCmd.CMD_STATUS__FAILED` rename to `TermCmd.CMD_STATUS__EXCEPTION`
- Added `JTUtils.hexToMsgId`
- Added `CmdAsyncCompletedMsg.ackSeqNo`

## Fixed
- `NullPointerException` threw when encode 9205_QryAvRes which `startTm` is null or `endTm` is null
- `JTUtils.isValidSimNo` does not compatible with 2019 revision of `JT/T 808` protocol

## Changed
- Shorten property names of CP_XXX serial class
- `TermAsyncCompletedMsg` rename to `CmdAsyncCompletedMsg`
- Bump `netty-all` from `4.1.65` to `4.1.72`
- Bump `commons-codec` from `1.13` to `1.15`
- Bump `commons-lang3` from `3.8.1` to `3.11`
- Bump `gson` from `2.8.6` to `2.8.9`
- Bump `dnsjava` from `3.3.1` to `3.4.2`

# 1.0.2 - [2021-10-20]
## Improvement
- Introduce CrcError class
- `JT808Decoder.decode()` throws CrcError when CRC verification failed.
