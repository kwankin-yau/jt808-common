/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import com.lucendar.gateway.common.trace.GatewayTraceManager;
import info.gratour.jt808common.TimerProvider;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jtcommon.LazyBytesProvider;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 驱动执行上下文
 */
public interface GnssDriverContext {

    /**
     * 取 ByteBufAllocator。
     *
     * @return ByteBufAllocator。
     */
    ByteBufAllocator alloc();

    /**
     * 取终端跟踪管理器
     *
     * @return 终端跟踪管理器
     */
    GatewayTraceManager traceManager();

    /**
     * 取时间提供者
     *
     * @return 时间提供者
     */
    TimerProvider timerProvider();

    /**
     * 取终端连入的时刻
     *
     * @return 终端连入的时刻
     */
    long connTime();

    /**
     * 取终端连接ID，主要用于调试、日志。终端连接ID唯一标识一次终端连接。
     *
     * @return 终端连接ID
     */
    String connId();

    /**
     * 取当前已经识别的终端识别号。
     *
     * @return 当前已经识别的终端识别号。如果尚未识别，返回 null 。
     */
    String simNo();

    /**
     * 驱动已经从报文中识别出终端识别号
     *
     * @param simNo 所识别出终端识别号
     * @param protoVer 协议版本号
     */
    void onRecognized(String simNo, String protoVer);

    /**
     * 报文数据帧成功解码事件。
     *
     * @param bytes 报文数据
     */
    void onFrameDecoded(LazyBytesProvider bytes);

    /**
     * 分解报文数据帧失败事件。
     *
     * @param bytes 数据帧
     * @param ex 异常。可为 null 。
     */
    void onFrameDecodingFailed(@NonNull LazyBytesProvider bytes, @Nullable Exception ex);

    /**
     * 消息解码失败事件。
     *
     * @param bytes 数据帧
     * @param ex 异常。可为 null 。
     */
    void onMsgDecodingFailed(LazyBytesProvider bytes, @Nullable Exception ex);

    /**
     * 消息成功解码事件。
     *
     * @param msg 解码的消息
     */
    void onMsgDecoded(JT808Msg msg);

    /**
     * 发送消息到终端。
     *
     * @param msg 所要发送的消息
     */
    void send(JT808Msg msg);

    /**
     * 发送消息给终端事件。
     *
     * @param msg 所要发送的消息。
     * @param encodedBytes 消息编码后的数据包。可能包含多个帧。
     */
    void onSendMsg(@NonNull JT808Msg msg, @NonNull LazyBytesProvider encodedBytes);
}
