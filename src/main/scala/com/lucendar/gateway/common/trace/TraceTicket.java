package com.lucendar.gateway.common.trace;

/**
 * 终端跟踪凭据，取消跟踪时，可调用此接口的 `untrace` 方法
 */
public interface TraceTicket {
    String appId();
    String simNo();

    /**
     * 取消跟踪
     */
    void untrace();
}
