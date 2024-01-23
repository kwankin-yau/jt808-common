package info.gratour.jtcommon;

/*
 * Copyright (C) 2002 Nick Galbreath.
 * All Rights Reserved.
 *
 * Orginally published in or based on works from the book
 *      Cryptography for Internet and Database Applications
 *      by Nick Galbreath
 *      Wiley Publishing, 2002
 *      ISBN 0-471-21029-3
 * See http://www.modp.com or http://www.wiley.com/compbooks/galbreath
 * for details.
 *
 * This software is provided as-is, without express or implied
 * warranty.  Permission to use, copy, modify, distribute or sell this
 * software, without fee, for any purpose and by any individual or
 * organization, is hereby granted, provided that the above copyright
 * notice, the original publication information and this paragraph
 * (i.e. this entire Java comment) appear in all copies.
 *
 */

/**
 * This class provides Binary Code Decimal encoding of a String of decimal
 * digits ("0" to "9").
 *
 * <p>
 * For more information, see Chapter 6, pages 203-204, in <i>Cryptography for
 * Internet and Database Applications </i>
 *
 * @author Nick Galbreath
 * @version 1.0.1
 */
public class BcdUtils {
    private BcdUtils() {
        // this is a pure 'static' class
    }

    /**
     * Encodes a string containing just decimal digis 0-9 into a backed binary
     * coded decimal array. For instance the decimal string "1234" will be
     * encoded into two bytes 0x12 0x34.
     *
     * @param s The input string
     * @return the BCD encoded binary array
     */
    public static byte[] encode(String s) {
        int i = 0, j = 0;
        int max = s.length() - (s.length() % 2);
        byte[] buf = new byte[(s.length() + (s.length() % 2)) / 2];
        while (i < max) {
            buf[j++] = (byte) ((((s.charAt(i++) - '0') << 4) | (s.charAt(i++) - '0')));
        }
        if ((s.length() % 2) == 1) { // If odd, add pad char
            buf[j] = (byte) ((s.charAt(i) - '0') << 4 | 0x0A);
        }
        return buf;
    }

    public static void encode(String s, byte[] buf, int offset) {
        int i = 0;
        int max = s.length() - (s.length() % 2);
        while (i < max) {
            buf[offset++] = (byte) ((((s.charAt(i++) - '0') << 4) | (s.charAt(i++) - '0')));
        }
        if ((s.length() % 2) == 1) { // If odd, add pad char
            buf[offset] = (byte) ((s.charAt(i) - '0') << 4 | 0x0A);
        }
    }

    /**
     * Decodes a BCD encoded array back into a String containing decimal digits.
     * For instance 0x34 will be decoded as the string "34".
     *
     * @param b the input BCD encoded array
     * @return The decoded, original string
     */
    public static String decode(byte[] b) {
        StringBuilder buf = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; ++i) {
            buf.append((char) (((b[i] & 0xf0) >> 4) + '0'));
            if ((i != b.length) && ((b[i] & 0xf) != 0x0A)) // if not pad char
                buf.append((char) ((b[i] & 0x0f) + '0'));
        }
        return buf.toString();
    }

    /**
     * Decodes a BCD encoded array back into a String containing decimal digits.
     * For instance 0x34 will be decoded as the string "34".
     *
     * @param b the input BCD encoded array
     * @param offset the offset in the buffer
     * @param length the encoded buffer size
     * @return The decoded, original string
     */
    public static String decode(byte[] b, int offset, int length) {
        StringBuilder buf = new StringBuilder(length * 2);
        for (int i = offset; i < length + offset; ++i) {
            buf.append((char) (((b[i] & 0xf0) >> 4) + '0'));
            if ((i != (length + offset)) && ((b[i] & 0xf) != 0x0A)) // if not pad char
                buf.append((char) ((b[i] & 0x0f) + '0'));
        }
        return buf.toString();
    }

    /**
     * 一位BCD转换成整数
     *
     * @param bcd BCD数
     * @return 整数
     */
    public static byte decodeByte(final byte bcd) {
        int r = bcd & 0x0F;
        r += ((bcd & 0xF0) >>> 4) * 10;
        return (byte) r;
    }

    /**
     * Convert an integer to bcd byte.
     *
     * @param value integer value.
     * @return bcd byte.
     */
    public static byte encodeByte(final int value) {
        int d1 = value % 10;
        int d2 = value % 100;
        d2 = d2 / 10;
        d2 = d2 << 4;
        d2 |= d1;
        return (byte) d2;
    }

    /**
     * Convert integer value to 2 bcd byte.
     *
     * @param value  Integer value.
     * @param buf    Output bcd byte array.
     * @param offset Output offset of the array.
     */
    private static void encodeShort(
            final int value, final byte[] buf,
            final int offset) {
        int i = value % 10000;
        i = i / 1000;

        int j = value % 1000;
        j = j / 100;

        i = i << 4;
        j |= i;

        buf[offset] = (byte) j;

        i = value % 10;
        j = value % 100;
        j = j / 10;
        j = j << 4;
        j |= i;
        buf[offset + 1] = (byte) j;
    }


}
