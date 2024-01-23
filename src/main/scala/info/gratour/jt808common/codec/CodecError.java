/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec;

import info.gratour.jtcommon.LazyBytesProvider;

public class CodecError extends RuntimeException {

    private LazyBytesProvider bytes;

    public CodecError(String message) {
        super(message);
    }
    public CodecError(String message, LazyBytesProvider bytes) {
        super(message);
        this.bytes = bytes;
    }

    public CodecError(String message, Throwable cause) {
        super(message, cause);
    }

    public CodecError(String message, LazyBytesProvider bytes, Throwable cause) {
        super(message, cause);
        this.bytes = bytes;
    }

    public LazyBytesProvider getBytes() {
        return bytes;
    }

}
