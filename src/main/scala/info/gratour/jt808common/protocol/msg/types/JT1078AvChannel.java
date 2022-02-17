/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class JT1078AvChannel {

    public static final byte MEDIA_TYPE__AV = 0;
    public static final byte MEDIA_TYPE__AUDIO_ONLY = 1;

    private byte channelId;
    private byte mediaType;
    private boolean custom;

    public JT1078AvChannel() {
    }

    public JT1078AvChannel(byte channelId, byte mediaType, boolean custom) {
        this.channelId = channelId;
        this.mediaType = mediaType;
        this.custom = custom;
    }

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public String getChannelName(Locale locale) {
        return channelName(channelId, locale);
    }

    public byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public String channelText(Locale locale) {
        return getChannelName(locale) + " (" + channelId + ")";
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT1078AvChannel.class.getSimpleName() + "[", "]")
                .add("channelId=" + channelId)
                .add("mediaType=" + mediaType)
                .add("custom=" + custom)
                .toString();
    }

    public static final ResourceBundle resourceBundle(Locale locale) {
        return ResourceBundle.getBundle("info.gratour.jt808common.protocol.channel-names", locale != null ? locale : Locale.getDefault());
    }

    public static String channelName(int channelId, Locale locale) {
        String key = "ch" + channelId;
        ResourceBundle bundle = resourceBundle(locale);
        if (bundle.containsKey(key)) {
            return bundle.getString(key);
        } else
            return key;
    }

    private static JT1078AvChannel ch(int channelId, boolean av) {
        byte mediaType = av ? MEDIA_TYPE__AV : MEDIA_TYPE__AUDIO_ONLY;
        return new JT1078AvChannel((byte) channelId, mediaType, false);
    }

    public final static JT1078AvChannel[] standardChannels = new JT1078AvChannel[]{
            ch(1, true),
            ch(2, true),
            ch(3, true),
            ch(4, true),
            ch(5, true),
            ch(6, true),
            ch(7, true),
            ch(8, true),
            ch(9, true),
            ch(10, true),
            ch(11, true),
            ch(12, true),
            ch(13, true),
            ch(33, false),
            ch(36, false),
            ch(37, false)
    };
}

