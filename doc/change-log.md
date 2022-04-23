# 2.0.0 - [2022-03-15]
## Improvement
- `0100`, `0102` message encoder added

## Changed
- Introduce `AdasDialect`
- Removed `JT808ProtocolVariant`, use protoVer and AdasDialect instead.
- Dependencies:
  - Bump `scala-library` FROM `2.13.6` to `2.13.8`
  - Bump `netty-all` FROM `4.1.72` to `4.1.74`


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
