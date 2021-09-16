/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.almatt;

public class AlmAttFileItem implements Cloneable {

    private String fileName;
    private int fileSize;
    private transient boolean uploadCompleted;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isUploadCompleted() {
        return uploadCompleted;
    }

    public void setUploadCompleted(boolean uploadCompleted) {
        this.uploadCompleted = uploadCompleted;
    }

    @Override
    public AlmAttFileItem clone() {
        try {
            return (AlmAttFileItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "AlmAttFileItem{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", uploadCompleted=" + uploadCompleted +
                '}';
    }
}
