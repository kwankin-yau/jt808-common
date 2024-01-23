/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common.trace;

/**
 * 终端调试跟踪状态
 */
public interface TraceStatus {

    String appId();
    String simNo();

    /**
     * 是否跟踪此终端
     *
     * @return 是否跟踪此终端
     */
    boolean isActive();
}
