/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.decoder.fragment;

import info.gratour.jt808common.protocol.JT808Frame;

import java.io.Closeable;

public interface CollectedFragment extends Closeable {

    int getMsgId();

    /**
     * Get all fragments stubs, null element for not received, otherwise received.
     *
     * @return all fragments stubs.
     */
    JT808Frame[] getFrames();

    int getTotalCount();

    int getRecvCount();

    boolean isAllFragmentReceived();

    void close();
}
