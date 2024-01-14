/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common.trace;

public interface TraceConfig {

    String appId();
    String simNo();

    boolean isActive();
}
