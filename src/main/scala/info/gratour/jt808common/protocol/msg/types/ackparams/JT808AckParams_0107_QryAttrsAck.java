/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.QRY_TERMINAL_ATTRS_ACK_0107)
public class JT808AckParams_0107_QryAttrsAck implements JT808AckParams, Cloneable {

    private short terminalType;
    private String factoryId;
    private String model;
    private String terminalId;
    private String iccid;
    private String hardwareVer;
    private String firmwareVer;
    private byte gnssModuleAttrs;
    private byte commModuleAttrs;

    public short getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(short terminalType) {
        this.terminalType = terminalType;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getHardwareVer() {
        return hardwareVer;
    }

    public void setHardwareVer(String hardwareVer) {
        this.hardwareVer = hardwareVer;
    }

    public String getFirmwareVer() {
        return firmwareVer;
    }

    public void setFirmwareVer(String firmwareVer) {
        this.firmwareVer = firmwareVer;
    }

    public byte getGnssModuleAttrs() {
        return gnssModuleAttrs;
    }

    public void setGnssModuleAttrs(byte gnssModuleAttrs) {
        this.gnssModuleAttrs = gnssModuleAttrs;
    }

    public byte getCommModuleAttrs() {
        return commModuleAttrs;
    }

    public void setCommModuleAttrs(byte commModuleAttrs) {
        this.commModuleAttrs = commModuleAttrs;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0107_QryAttrsAck{" +
                "terminalType=" + terminalType +
                ", factoryId='" + factoryId + '\'' +
                ", model='" + model + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", iccid='" + iccid + '\'' +
                ", hardwareVer='" + hardwareVer + '\'' +
                ", firmwareVer='" + firmwareVer + '\'' +
                ", gnssModuleAttrs=" + gnssModuleAttrs +
                ", commModuleAttrs=" + commModuleAttrs +
                '}';
    }

    @Override
    public JT808AckParams_0107_QryAttrsAck clone() {
        try {
            return (JT808AckParams_0107_QryAttrsAck) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
