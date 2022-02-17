/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

public class Vtdr_RevEvent implements Cloneable {

    private String time;
    private byte cmd;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    @Override
    public Vtdr_RevEvent clone() {
        try {
            return (Vtdr_RevEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_RevEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("cmd=" + cmd)
                .toString();
    }
}
