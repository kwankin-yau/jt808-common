/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */

package com.lucendar.gateway.common.trace;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * 终端跟踪管理器
 */
public interface GatewayTraceManager {

    /**
     * 取跟踪状态
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 终端跟踪状态
     */
    TraceStatus getTraceStatus(@NonNull String appId, @NonNull String simNo);

    /**
     * 跟踪终端
     *
     * @param appId 应用ID
     * @param simNo 终端识别号
     * @return 终端跟踪
     */
    TraceTicket trace(@NonNull String appId, @NonNull String simNo);
}
