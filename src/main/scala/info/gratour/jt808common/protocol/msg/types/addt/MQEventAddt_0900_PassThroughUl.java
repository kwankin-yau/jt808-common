/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.addt;

import java.util.Arrays;
import java.util.StringJoiner;

public class MQEventAddt_0900_PassThroughUl implements MQEventAddt {

    private byte typ;
    private byte[] data;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MQEventAddt_0900_PassThroughUl.class.getSimpleName() + "[", "]")
                .add("typ=" + typ)
                .add("data=" + Arrays.toString(data))
                .toString();
    }
}
