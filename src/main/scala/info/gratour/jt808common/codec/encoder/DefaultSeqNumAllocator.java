/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.encoder;

public class DefaultSeqNumAllocator implements SeqNumAllocator {

    private int seed = 1;

    @Override
    public int nextSeqNo() {
        return seed++;
    }

    public void reset() {
        seed = 1;
    }
}
