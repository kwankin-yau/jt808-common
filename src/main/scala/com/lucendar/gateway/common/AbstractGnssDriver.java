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
    protected final GnssDriverContext ctx;

    public AbstractGnssDriver(boolean verifyCrc, Map<String, String> attrs, GnssDriverContext ctx) {
        this.initVerifyCrc = verifyCrc;
        this.verifyCrc = verifyCrc;
        this.initAttrs = attrs;
        this.attrs = new HashMap<>();
        this.attrs.putAll(attrs);
        this.ctx = ctx;
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

    protected Object getAttrDefault(String attr, Object defaultValue) {
        Object r = findAttr(attr);
        if (r == null)
            return defaultValue;
        else
            return r;
    }

    protected String getStringAttr(String attr) {
        return getAttr(attr).toString();
    }

    protected String getStringAttrDefault(String attr, String defaultValue) {
        return getAttrDefault(attr, defaultValue).toString();
    }

    protected boolean getBooleanAttr(String attr) {
        Object value = getAttr(attr);
        if (value instanceof Boolean)
            return (Boolean) value;
        else
            return Boolean.parseBoolean(value.toString());
    }

    protected boolean getBooleanAttrDefault(String attr, boolean defaultValue) {
        Object value = findAttr(attr);
        if (value == null)
            return defaultValue;
        else if (value instanceof Boolean)
            return (Boolean) value;
        else
            return Boolean.parseBoolean(value.toString());
    }

    protected void setAttr(String attr, Object value) {
        attrs.put(attr, value);
    }

    public GnssDriverContext getCtx() {
        return ctx;
    }

    @Override
    public void reset() {
        verifyCrc = initVerifyCrc;
        attrs.clear();
        if (initAttrs != null)
            attrs.putAll(initAttrs);
    }
}
