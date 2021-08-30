/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtcommon;

public interface JTMsg {

    int jtMsgId();

    default String jtMsgIdToHex() {
        return JTUtils.msgIdToHex(jtMsgId());
    }

}
