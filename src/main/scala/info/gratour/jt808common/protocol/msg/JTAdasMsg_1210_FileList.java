/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItem;
import info.gratour.jtcommon.JTMsgId;

import java.util.ArrayList;
import java.util.List;

@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_LIST_1210)
public class JTAdasMsg_1210_FileList extends JT808Msg {

    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_FILE_LIST_1210;

    public static final byte KIND__NORMAL = 0;
    public static final byte KIND__RETRANSMIT = 1;

    public JTAdasMsg_1210_FileList() {
        setMsgId(MSG_ID);
    }

    public JTAdasMsg_1210_FileList(JT808FrameHeader header) {
        super(header);
    }

    private String termId;
    private String almNo;
    private String platformAlmId;
    private byte kind;
    private List<AlmAttFileItem> fileList;

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getAlmNo() {
        return almNo;
    }

    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    public String getPlatformAlmId() {
        return platformAlmId;
    }

    public void setPlatformAlmId(String platformAlmId) {
        this.platformAlmId = platformAlmId;
    }

    public byte getKind() {
        return kind;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    public List<AlmAttFileItem> getFileList() {
        return fileList;
    }

    public void setFileList(List<AlmAttFileItem> fileList) {
        this.fileList = fileList;
    }

    public void addFile(AlmAttFileItem fileItem) {
        if (this.fileList == null)
            this.fileList = new ArrayList<>();

        this.fileList.add(fileItem);
    }

    @Override
    public String toString() {
        return "JTAdasMsg_1210_FileList{" +
                "termId='" + termId + '\'' +
                ", almNo='" + almNo + '\'' +
                ", platformAlmId='" + platformAlmId + '\'' +
                ", kind=" + kind +
                ", fileList=" + fileList +
                '}';
    }
}
