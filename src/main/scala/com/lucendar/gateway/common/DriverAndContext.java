/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gateway.common;

public class DriverAndContext {

    private final GnssDriverFactory factory;
    private final GnssDriver driver;

    public DriverAndContext(GnssDriverFactory factory, GnssDriver driver) {
        this.factory = factory;
        this.driver = driver;
    }

    public GnssDriverFactory getFactory() {
        return factory;
    }

    public GnssDriver getDriver() {
        return driver;
    }
}
