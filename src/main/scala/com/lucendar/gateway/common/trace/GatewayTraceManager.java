/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */

package com.lucendar.gateway.common.trace;

import org.checkerframework.checker.nullness.qual.NonNull;

public interface GatewayTraceManager {

    TraceConfig getTraceConfig(@NonNull String appId, @NonNull String simNo);

    TraceTicket trace(@NonNull String appId, @NonNull String simNo);
}
