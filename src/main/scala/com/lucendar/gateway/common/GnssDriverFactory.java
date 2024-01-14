/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.jt808common.TimerProvider;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.Map;

/**
 * 终端驱动
 */
public interface GnssDriverFactory {

    String CONFIG__ADAS_DIALECT = "adasDialect";

    /**
     * 驱动的ID，不同的驱动，其ID必须不一。
     *
     * @return
     */
    String id();

    /**
     * 检查一个报文是否可由本驱动处理。
     *
     * @param buf
     * @return
     */
    boolean probe(ByteBuf buf);

    /**
     * 创建驱动处理上下文
     *
     * @param config 驱动的初始配置
     * @param verifyCrc 是否校验报文的校验码
     * @param alloc
     * @param timerProvider
     * @return
     */
    GnssDriver createDriver(
            Map<String, String> config,
            boolean verifyCrc,
            ByteBufAllocator alloc,
            TimerProvider timerProvider);

    default GnssDriver createDriver(
            Map<String, String> config,
            ByteBufAllocator alloc,
            TimerProvider timerProvider) {
        return createDriver(config, true, alloc, timerProvider);
    }
}
