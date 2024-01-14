package com.lucendar.gateway.common.trace;

public interface TraceTicket {
    String appId();
    String simNo();

    void untrace();
}
