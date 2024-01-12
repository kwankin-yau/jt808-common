/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.jt808common.codec.CodecError;
import info.gratour.jt808common.codec.decoder.JT808MsgReceiver;
import info.gratour.jt808common.protocol.JT808Msg;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.Closeable;
import java.io.IOException;

/**
 * 驱动实例
 */
public interface GnssDriver extends Closeable {

    /**
     * 解码报文
     *
     * @param buf      报文
     * @param receiver 成功解码的消息接收者
     * @throws CodecError 解码失败时，抛出 CodecError
     */
    void decode(ByteBuf buf, JT808MsgReceiver receiver) throws CodecError;

    /**
     * 当一条终端连接空闲达到`checkAliveIntv`时，网关调用此方法构建一个下发都终端的消息，用于检查连接是否仍然有效。对于JT/T 808驱动，
     * 可以返回查询终端属性指令，或查询特定终端参数指令。如果驱动不支持，可返回 null。
     *
     * @param simNo 终端识别号
     * @return 用于检查连接是否仍然有效的消息。
     */
    @Nullable
    JT808Msg buildCheckAliveMsg(String simNo);


    /**
     * 重置驱动上下文
     */
    void reset();

    /**
     * 关闭驱动
     */
    void close();
}
