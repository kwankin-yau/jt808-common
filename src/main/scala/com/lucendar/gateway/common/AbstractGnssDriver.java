/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

import info.gratour.common.error.ErrorWithCode;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractGnssDriver implements GnssDriver {

    protected final boolean initVerifyCrc;
    protected boolean verifyCrc;
    protected final Map<String, String> initAttrs;
    protected final Map<String, Object> attrs;

    public AbstractGnssDriver(boolean verifyCrc, Map<String, String> attrs) {
        this.initVerifyCrc = verifyCrc;
        this.verifyCrc = verifyCrc;
        this.initAttrs = attrs;
        this.attrs = new HashMap<>();
        this.attrs.putAll(attrs);
    }

    protected Object findAttr(String attr) {
        return attrs.get(attr);
    }

    protected Object getAttr(String attr) {
        Object r = findAttr(attr);
        if (r == null) {
            String err = String.format("Attribute `%s` is not found.", attr);
            throw ErrorWithCode.recordNotFound(err);
        }

        return r;
    }

    protected String getStringAttr(String attr) {
        return getAttr(attr).toString();
    }

    protected boolean getBooleanAttr(String attr) {
        return Boolean.parseBoolean(getStringAttr(attr));
    }

    protected void setAttr(String attr, Object value) {
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
