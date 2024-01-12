JT/T 808/1078协议、ADAS协议公共库

1. 定义JT/T 808/1078协议、各省ADAS标准中各种常量、消息的实体类型及相应的编解码，编解码主要在netty的ByteBuf对象上操作
2. 支持2013, 2019两个版本的协议（2013版系指2011版 + 2013年的补充协议）
3. 定义驱动的接口原型 (GnssDriver/GnssDriverContext等)

# 编码
```java
JT808FrameEncoder.encode(JT808Consts.);
```

# 解码
```java
// 创建解码器，根据项目情况，选择合适的 AdasDialect，此处为广东的团体标准
var decoder = new JT808MsgDecoder(AdasDialect.GDRTA_2020, false);

// 先分包，得到一个 JT808Frame
var tempBuf = JT808MsgDecoder.allocDecodeTempBuf()
JT808Frame frame = JT808FrameDecoder.decodeFrame(buf, tempBuf) // `buf` 为 netty 的 数据包

// 传给 decoder，解码得到消息
var decodedMsg = decoder.decode(frame, tempBuf)
if (decodedMsg == null)
  throw new RuntimeException("Decode failed")   // 如果得到的是 null ，表示解码失败
  
// ... 此后可以使用 decodedMsg 作相应的业务处理
```
