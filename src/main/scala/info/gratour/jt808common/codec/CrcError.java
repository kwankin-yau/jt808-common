/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec;

public class CrcError extends CodecError {

    public CrcError(String message) {
        super(message);
    }

    public CrcError(String message, Throwable cause) {
        super(message, cause);
    }

}
