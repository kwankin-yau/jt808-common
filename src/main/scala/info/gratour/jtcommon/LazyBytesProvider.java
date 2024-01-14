/*
 * Copyright (c) 2024  lucendar.com.
 * All rights reserved.
 */
package info.gratour.jtcommon;

/**
 * 惰性字节数组数据提供者。
 */
public interface LazyBytesProvider {

    /**
     * 取数据的字节数组。
     *
     * @return 数据的字节数组。
     */
    byte[] binary();

    /**
     * 取数据的HEX表示字符串。
     *
     * @return 数据的HEX表示字符串。
     */
    String hex();
}
