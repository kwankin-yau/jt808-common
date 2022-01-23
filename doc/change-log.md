# 1.0.3 - [2022-01-22]
## Improvement
- `CmdAck` add `reqTm` property
- Introduce `TermCmdCompleted` message

## Changed
- Bump `netty-all` from `4.1.65` to `4.1.72`
- Bump `commons-codec` from `1.13` to `1.15`
- Bump `commons-lang3` from `3.8.1` to `3.11`
- Bump `gson` from `2.8.6` to `2.8.9`
- Bump `dnsjava` from `3.3.1` to `3.4.2`

# 1.0.2 - [2021-10-20]
## Improvement
- Introduce CrcError class
- `JT808Decoder.decode()` throws CrcError when CRC verification failed.
