JT/T 808/1078协议、ADAS协议公共库

1. 定义JT/T 808/1078协议、各省ADAS标准中各种常量、消息的实体类型及相应的编解码，编解码主要在netty的ByteBuf对象上操作
2. 支持2013, 2019两个版本的协议（2013版系指2011版 + 2013年的补充协议）
3. 定义驱动的接口原型 (GnssDriver/GnssDriverContext等)

# 包引用
## Maven
```xml
<dependency>
    <groupId>com.lucendar</groupId>
    <artifactId>jt808-common</artifactId>
    <version>3.0.0</version>
</dependency>
```

## Gradle
```groovy
implementation 'com.lucendar:jt808-common:3.0.0'
```
