/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Vtdr_Status implements Cloneable {
    private byte stateWord;
    private List<String> bitDesc;

    public byte getStateWord() {
        return stateWord;
    }

    public void setStateWord(byte stateWord) {
        this.stateWord = stateWord;
    }

    public List<String> getBitDesc() {
        return bitDesc;
    }

    public void setBitDesc(List<String> bitDesc) {
        this.bitDesc = bitDesc;
    }

    public void addBitDesc(String bitDesc) {
        if (this.bitDesc == null)
            this.bitDesc = new ArrayList<>();
        this.bitDesc.add(bitDesc);
    }

    public void assignFrom(Vtdr_Status source) {
        this.stateWord = source.stateWord;
        if (source.bitDesc != null) {
            this.bitDesc = new ArrayList<>();
            this.bitDesc.addAll(source.bitDesc);
        } else
            this.bitDesc = null;
    }

    @Override
    public Vtdr_Status clone() {
        try {
            return (Vtdr_Status) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_Status.class.getSimpleName() + "[", "]")
                .add("stateWord=" + stateWord)
                .add("bitDesc=" + bitDesc)
                .toString();
    }
}
