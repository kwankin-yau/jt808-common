/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common;

import info.gratour.jtcommon.JTUtils;

import java.util.Locale;

public class JT808StateBits {

    private int stateBits;

    public int getStateBits() {
        return stateBits;
    }

    public void setStateBits(int stateBits) {
        this.stateBits = stateBits;
    }

    public boolean test(JT808StateBit bit) {
        return JTUtils.test(stateBits, bit.bitIndex());
    }

    public boolean test(int bitIndex) {
        return JTUtils.test(stateBits, bitIndex);
    }

    public JT808StateBits set(JT808StateBit bit) {
        stateBits = JTUtils.set(stateBits, bit.bitIndex());
        return this;
    }

    public JT808StateBits set(int bitIndex) {
        stateBits = JTUtils.set(stateBits, bitIndex);
        return this;
    }

    public JT808StateBits clear(JT808StateBit bit) {
        stateBits = JTUtils.clear(stateBits, bit.bitIndex());
        return this;
    }

    public JT808StateBits clear(int bitIndex) {
        stateBits = JTUtils.clear(stateBits, bitIndex);
        return this;
    }

    public String getStateText(Locale locale) {
        return JT808StateBit.vehStateText(stateBits, locale);
    }

    public static final JT808StateBits ACC_ON_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.ACC_ON).set(JT808StateBit.LOCATED);
    public static final JT808StateBits ACC_OFF_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.LOCATED);

    @Override
    public String toString() {
        return "JT808StateBits{" +
                "stateBits=" + stateBits +
                '}';
    }
}
