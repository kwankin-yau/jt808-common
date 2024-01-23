/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec;

import info.gratour.jtcommon.LazyBytesProvider;

public class CrcError extends CodecError {

    private LazyBytesProvider bytes;
    public CrcError(String message) {
        super(message);
    }

    public CrcError(String message, LazyBytesProvider bytes) {
        super(message);
        this.bytes = bytes;
    }

    public CrcError(String message, Throwable cause) {
        super(message, cause);
    }
    public CrcError(String message, LazyBytesProvider bytes, Throwable cause) {
        super(message, cause);
        this.bytes = bytes;
    }

    @Override
    public LazyBytesProvider getBytes() {
        return bytes;
    }
}
