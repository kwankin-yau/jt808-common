/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.decoder;

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment;

public interface FragmentTimeoutCallback {

    void onFragmentTimeout(CollectedFragment collectedFragment);
}
