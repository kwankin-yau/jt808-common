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

public class Vtdr_StatusSignalNames {

    private List<String> bitDesc;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_StatusSignalNames.class.getSimpleName() + "[", "]")
                .add("bitDesc=" + bitDesc)
                .toString();
    }
}
