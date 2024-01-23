/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.jt808common.codec.CodecError;
import info.gratour.jt808common.protocol.JT808Msg;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.io.Closeable;

/**
 * 驱动实例
 */
public interface GnssDriver extends Closeable {

    /**
     * 解码报文。网关在接收到报文后，将调用本方法进行解包。
     * <p>
     * 驱动需要自行进行缓存、分包、反转义、校验CRC等操作，并:
     * <ol>
     *     <li>在第一次从报文中识别出终端识别号以后，调用 GnssDriverContext.onRecognized() 方法通知网关
     *     <li>解包得到的消息，应调用 GnssDriverContext.onMsgDecoded() 方法将解码后的消息提交给网关
     *     <li>解码过程中，驱动应检查、处理好异常，并根据实际情况，调用 GnssDriverContext.onFrameDecodingFailed() 或 GnssDriverContext.onMsgDecodingFailed()方法。
     * </ol>
     * 如果decode()方法产生未检查异常(unchecked exception)，网关将关闭终端连接和驱动。
     *
     * @param buf 报文。
     */
    void decode(ByteBuf buf);

    /**
     * 消息编码
     * <p>
     * 如果encode()方法产生未检查异常(unchecked exception)，网关将关闭终端连接和驱动。
     *
     * @param msg 所要编码的消息
     * @param out 输出 ByteBuf
     */
    void encode(JT808Msg msg, ByteBuf out);

//    /**
//     * 初始化、设置一个新消息的属性，如 `seqNo` 属性
//     *
//     * @param msg
//     */
//    void setupNewMsg(JT808Msg msg);

    /**
     * 当一条终端连接空闲达到`checkAliveIntv`时，网关调用此方法构建一个下发都终端的消息，用于检查连接是否仍然有效。对于JT/T 808驱动，
     * 可以返回查询终端属性指令，或查询特定终端参数指令。如果驱动不支持，可返回 null。
     *
     * @param simNo 终端识别号
     * @return 用于检查连接是否仍然有效的消息。
     */
    @Nullable
    JT808Msg buildCheckAliveMsg(String simNo);


    /**
     * 重置驱动上下文
     */
    void reset();

    /**
     * 关闭驱动
     */
    void close();
}
