/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common.trace;

import java.util.concurrent.atomic.AtomicInteger;

public class TraceTicketImpl implements TraceTicket, TraceStatus {

    private final String appId;
    private final String simNo;
    private final AtomicInteger traceCount = new AtomicInteger();

    public TraceTicketImpl(String appId, String simNo) {
        this.appId = appId;
        this.simNo = simNo;
    }

    @Override
    public boolean isActive() {
        return traceCount.get() > 0;
    }

    @Override
    public String appId() {
        return appId;
    }

    @Override
    public String simNo() {
        return simNo;
    }

    @Override
    public void untrace() {
        traceCount.decrementAndGet();
    }

    public void trace() {
        traceCount.incrementAndGet();
    }
}
