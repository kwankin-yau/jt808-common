/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

import java.time.Instant;
import java.time.OffsetDateTime;

public class TermCmd implements Cloneable {

    public static final int CMD_STATUS__INIT = 0;
    public static final int CMD_STATUS__SENT = 1;
    public static final int CMD_STATUS__ACK = 2;
    public static final int CMD_STATUS__EXCEPTION = -1;
    public static final int CMD_STATUS__BAD_CMD = -2;
    public static final int CMD_STATUS__NOT_SUPPORTED = -3;
    public static final int CMD_STATUS__CANCELED = -4;
    public static final int CMD_STATUS__NO_CONNECTION = -5;
    public static final int CMD_STATUS__TIMEOUT = -6;

    public static boolean isAckOrCompletedStatus(int status) {
        switch (status) {
            case CMD_STATUS__ACK:
            case CMD_STATUS__EXCEPTION:
            case CMD_STATUS__BAD_CMD:
            case CMD_STATUS__NOT_SUPPORTED:
            case CMD_STATUS__CANCELED:
            case CMD_STATUS__NO_CONNECTION:
            case CMD_STATUS__TIMEOUT:
                return true;

            default:
                return false;
        }
    }

    private String appId = "";

    /**
     * TermCmd record ID
     */
    private String id;

    /**
     * The ID of request, that issued by user, initiated this terminal command. May be null. This property used for
     * associate the terminal command with the initial request. If this property is null, that means this command has
     * no initial request or the initial request is unknown.
     */
    private String reqId;

    private long reqTm;
    private Long sentTm;
    private Long ackTm;
    private Long endTm;
    private int status;
    private String simNo;
    private String msgId;
    private String subCmdTyp;
    private String plateNo;
    private Integer plateColor;
    private Integer msgSn;
    private JT808CmdParams params;
    private Integer ackCode;
    private JT808AckParams ackParams;
    private Integer timeout;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * Get request time of the terminal command, in epoch millis.
     *
     * @return request time in epoch millis.
     */
    public long getReqTm() {
        return reqTm;
    }

    private static OffsetDateTime toOffsetDateTime(Long tm) {
        if (tm != null)
            return OffsetDateTime.ofInstant(Instant.ofEpochMilli(tm), JTConsts.ZONE_OFFSET_BEIJING());
        else
            return null;
    }

    private static Long toEpochMilli(OffsetDateTime odt) {
        if (odt != null)
            return odt.toInstant().toEpochMilli();
        else
            return null;
    }

    public OffsetDateTime getReqTmOdt() {
        return toOffsetDateTime(reqTm);
    }

    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    public void setReqTm(OffsetDateTime odt) {
        if (odt == null)
            throw new NullPointerException();

        this.reqTm = toEpochMilli(odt);
    }

    public Long getSentTm() {
        return sentTm;
    }

    public OffsetDateTime getSentTmOdt() {
        return toOffsetDateTime(sentTm);
    }

    public void setSentTm(Long sentTm) {
        this.sentTm = sentTm;
    }

    public void setSentTm(OffsetDateTime odt) {
        this.sentTm = toEpochMilli(odt);
    }

    public Long getAckTm() {
        return ackTm;
    }

    public OffsetDateTime getAckTmOdt() {
        return toOffsetDateTime(ackTm);
    }

    public void setAckTm(Long ackTm) {
        this.ackTm = ackTm;
    }

    public void setAckTm(OffsetDateTime odt) {
        this.ackTm = toEpochMilli(odt);
    }

    public Long getEndTm() {
        return endTm;
    }

    public OffsetDateTime getEndTmOdt() {
        return toOffsetDateTime(endTm);
    }

    public void setEndTm(Long endTm) {
        this.endTm = endTm;
    }

    public void setEndTm(OffsetDateTime odt) {
        this.endTm = toEpochMilli(odt);
    }


    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * @return JT808 message ID. For example, '0200' is location report message.
     */
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


    public int jtMsgId() {
        return Integer.parseInt(msgId, 16);
    }

    public void jtMsgId(int jtMsgId) {
        msgId = JTUtils.msgIdToHex(jtMsgId);
    }

    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    /**
     * @return null if plate no does not assigned, or has no vehicle bound to the terminal yet.
     */
    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }


    /**
     * @return null if plate color does not assigned, or has no vehicle bound to the terminal yet.
     */
    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * @return null if has not been sent yet
     */
    public Integer getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    public JT808CmdParams getParams() {
        return params;
    }

    public void setParams(JT808CmdParams params) {
        this.params = params;
    }

    public String paramsJson() {
        JT808CmdParams params = getParams();
        if (params != null)
            return JTConsts.GSON().toJson(params);
        else
            return null;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean acknowledged() {
        return status == TermCmd.CMD_STATUS__ACK;
    }

    public boolean completed() {
        return TermCmd.isAckOrCompletedStatus(status);
    }

    public Integer getAckCode() {
        return ackCode;
    }

    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    public JT808AckParams getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    public String ackParamsJson() {
        JT808AckParams ackParams = getAckParams();
        if (ackParams != null)
            return JTConsts.GSON().toJson(ackParams);
        else
            return null;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void assignFrom(TermCmd source) {
        this.appId = source.appId;
        this.id = source.id;
        this.reqTm = source.reqTm;
        this.sentTm = source.sentTm;
        this.ackTm = source.ackTm;
        this.endTm = source.endTm;
        this.status = source.status;
        this.simNo = source.simNo;
        this.msgId = source.msgId;
        this.subCmdTyp = source.subCmdTyp;
        this.plateNo = source.plateNo;
        this.plateColor = source.plateColor;
        this.msgSn = source.msgSn;
        this.params = source.params != null ? source.params.clone() : null;
        this.ackCode = source.ackCode;
        this.ackParams = source.ackParams != null ? source.ackParams.clone() : null;
        this.timeout = source.timeout;
    }



    @Override
    public TermCmd clone() {
        TermCmd r = new TermCmd();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("appId=").append(appId);
        str.append(", id=").append(id);
        str.append(", simNo=").append(simNo);
        str.append(", msgId=").append(msgId);
        if (msgSn != null)
            str.append(", msgSn=").append(msgSn);
        if (params != null)
            str.append(", params=").append(params);
        str.append(", reqTm=").append(reqTm);
        str.append(", sentTm=").append(sentTm);
        if (ackTm != null)
            str.append(", ackTm=").append(ackTm);
        if (endTm != null)
            str.append(", endTm=").append(endTm);
        str.append(", status=").append(status);
        if (subCmdTyp != null)
            str.append(", subCmdTyp=").append(subCmdTyp);
        if (plateNo != null)
            str.append(", plateNo=").append(plateNo);
        if (plateColor != null)
            str.append(", plateColor=").append(plateColor);
        if (ackCode != null)
            str.append(", ackCode=").append(ackCode);
        if (ackParams != null)
            str.append(", ackParams=").append(ackParams);
        if (timeout != null)
            str.append(", timeout=").append(timeout);

        return str.toString();
    }
}
