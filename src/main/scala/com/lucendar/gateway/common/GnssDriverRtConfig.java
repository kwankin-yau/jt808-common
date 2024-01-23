/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.jt808common.AdasDialect;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class GnssDriverRtConfig {

    private final String id;
    private final Map<String, String> config;
    private final AdasDialect adasDialect;

    private static final Map<String, String> EMPTY_CONFIG = Collections.unmodifiableMap(new HashMap<>());

    /**
     * 构造函数
     *
     * @param id 驱动ID
     * @param config 驱动配置
     * @param adasDialect ADAS方言
     */
    public GnssDriverRtConfig(@NonNull String id, @Nullable Map<String, String> config, @Nullable AdasDialect adasDialect) {
        this.id = id;
        this.config = config != null ? Collections.unmodifiableMap(config) : EMPTY_CONFIG;
        this.adasDialect = adasDialect;
    }

    /**
     * 取驱动的ID
     *
     * @return 驱动的ID
     */
    public String getId() {
        return id;
    }

    /**
     * 取驱动配置。
     *
     * @return 驱动配置键值对。注意不要修改返回的 Map。
     */
    public Map<String, String> getConfig() {
        return config;
    }

    /**
     * 取Adas方言。
     *
     * @return Adas方言。
     */
    @Nullable
    public AdasDialect getAdasDialect() {
        return adasDialect;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GnssDriverRtConfig.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("config=" + config)
                .add("adasDialect=" + adasDialect)
                .toString();
    }
}
