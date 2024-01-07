/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.jt808common.AdasDialect;
import info.gratour.jt808common.codec.CodecError;
import info.gratour.jt808common.codec.decoder.JT808MsgReceiver;
import info.gratour.jt808common.protocol.JT808Msg;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

/**
 * 终端驱动
 */
public interface GnssDriver {

    String CONFIG__ADAS_DIALECT = "adasDialect";


    /**
     * 驱动的ID，不同的驱动，其ID必须不一。
     *
     * @return
     */
    String id();

    /**
     * 创建驱动处理上下文
     *
     * @param config 驱动的初始配置
     * @param adasDialect ADAS协议方言
     * @param verifyCrc 是否校验报文的校验码
     * @return
     */
    GnssDriverContext createContext(Map<String, String> config, AdasDialect adasDialect, boolean verifyCrc);

    default GnssDriverContext createContext(Map<String, String> config, AdasDialect adasDialect) {
        return createContext(config, adasDialect, true);
    }
    default GnssDriverContext createContext(Map<String, String> config) {
        return createContext(config, null);
    }

    /**
     * 检查一个报文是否可由本驱动处理。
     *
     * @param ctx
     * @param buf
     * @return
     */
    boolean probe(GnssDriverContext ctx, ByteBuf buf);

    /**
     * 解码报文
     *
     * @param ctx
     * @param buf
     * @param receiver
     * @throws CodecError
     */
    void decode(GnssDriverContext ctx, ByteBuf buf, JT808MsgReceiver receiver) throws CodecError;

    /**
     * 当一条终端连接空闲达到`checkAliveIntv`时，网关调用此方法构建一个下发都终端的消息，用于检查连接是否仍然有效。对于JT/T 808驱动，
     * 可以返回查询终端属性指令，或查询特定终端参数指令。如果驱动不支持，可返回 null。
     *
     * @param simNo 终端识别号
     *
     * @return 用于检查连接是否仍然有效的消息。
     */
    @Nullable
    JT808Msg buildCheckAliveMsg(String simNo);
}
