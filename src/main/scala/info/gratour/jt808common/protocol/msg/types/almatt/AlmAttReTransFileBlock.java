/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.almatt;

public class AlmAttReTransFileBlock implements Cloneable {

    private int offset;
    private int size;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public AlmAttReTransFileBlock clone() {
        try {
            return (AlmAttReTransFileBlock) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AlmAttReTransFileBlock{" +
                "offset=" + offset +
                ", size=" + size +
                '}';
    }
}
