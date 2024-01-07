/*
 * Copyright (c) 2023  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

/**
 * 驱动上下文
 */
public interface GnssDriverContext {

    /**
     * 是否校验报文的校验码
     */
    boolean verifyCrc();
    void verifyCrc(boolean value);


    /**
     * 上下文的属性。驱动上下文创建后，EndPointConfig中的 `config`配置会通过本类实例的`setAttr`方法传入。
     *
     * @param attr
     * @return
     */
    Object getAttr(String attr);
    void setAttr(String attr, Object value);

    /**
     * 重置驱动上下文
     */
    void reset();
}
