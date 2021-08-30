/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.msgtransform;

import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.spi.model.TermCmd;

public interface TerminalCmdToMsgTransformer {

    JT808Msg toMsg(TermCmd cmd);
}
