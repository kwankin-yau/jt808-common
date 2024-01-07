/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import java.util.HashMap;
import java.util.Map;

public class SimpleDriverContext implements GnssDriverContext {

    private final boolean initVerifyCrc;
    private boolean verifyCrc;
    private final Map<String, String> initAttrs;
    private final Map<String, Object> attrs;

    public SimpleDriverContext(boolean verifyCrc, Map<String, String> attrs) {
        this.initVerifyCrc = verifyCrc;
        this.verifyCrc = verifyCrc;
        this.initAttrs = attrs;
        this.attrs = new HashMap<>();
        this.attrs.putAll(attrs);
    }

    @Override
    public boolean verifyCrc() {
        return verifyCrc;
    }

    @Override
    public void verifyCrc(boolean value) {
        this.verifyCrc = value;
    }

    @Override
    public Object getAttr(String attr) {
        return attrs.get(attr);
    }

    @Override
    public void setAttr(String attr, Object value) {
        attrs.put(attr, value);
    }

    @Override
    public void reset() {
        verifyCrc = initVerifyCrc;
        attrs.clear();
        if (initAttrs != null)
            attrs.putAll(initAttrs);
    }
}
