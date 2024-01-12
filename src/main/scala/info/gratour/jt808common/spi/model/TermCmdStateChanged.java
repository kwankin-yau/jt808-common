/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;
import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jtcommon.JTUtils;

import java.lang.reflect.Type;
import java.util.StringJoiner;

public class TermCmdStateChanged {

    public static final Type TYPE = new TypeToken<TermCmdStateChanged>() {
    }.getType();


    private String appId;

    private String id;
    private String externalId;
    private String reqId;
    private String reqTm;

    private int status;
    private String tm;

    private String initMsgId;
    private String subCmdTyp;

    private Integer msgSn;

    private String simNo;
    private String plateNo;
    private Integer plateColor;

    private String ackMsgId;
    private Integer ackSeqNo;
    private Integer ackCode;
    private JT808AckParams ackParams;

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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqTm() {
        return reqTm;
    }

    public void setReqTm(long reqTm) {
        this.reqTm = DateTimeUtils.BeijingConv.millisToString(reqTm);
    }

    public void setReqTm(String reqTm) {
        this.reqTm = reqTm;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = DateTimeUtils.BeijingConv.millisToString(tm);
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getInitMsgId() {
        return initMsgId;
    }

    public void setInitMsgId(String initMsgId) {
        this.initMsgId = initMsgId;
    }

    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    public Integer getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public String getAckMsgId() {
        return ackMsgId;
    }

    public void setAckMsgId(String ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    /**
     * 应答消息的流水号
     *
     * @return 应答消息的流水号
     */
    public Integer getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(Integer ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
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

    public boolean acknowledged() {
        return status == TermCmd.CMD_STATUS__ACK;
    }

    public boolean isSuccess() {
        return status == TermCmd.CMD_STATUS__ACK && (ackCode == null || ackCode == 0);
    }

    public boolean ackOrCompleted() {
        return TermCmd.isAckOrCompletedStatus(status);
    }

    public boolean completedDueToError() {
        return status < 0;
    }

    /**
     *
     * @param cmd
     * @param changeTm 状态变更的时间
     */
    public void assign(TermCmd cmd, long changeTm) {
        this.appId = cmd.appIdDef();
        this.id = cmd.getId();
        this.externalId = cmd.getExternalId();
        this.reqId = cmd.getReqId();
        this.reqTm = DateTimeUtils.BeijingConv.millisToString(cmd.getReqTm());
        this.status = cmd.getStatus();
        this.tm = DateTimeUtils.BeijingConv.millisToString(changeTm);
        this.initMsgId = cmd.getMsgId();
        this.subCmdTyp = cmd.getSubCmdTyp();
        this.msgSn = cmd.getMsgSn();
        this.simNo = cmd.getSimNo();
        this.plateNo = cmd.getPlateNo();
        this.plateColor = cmd.getPlateColor();

        this.ackMsgId = cmd.getAckMsgId();
        this.ackSeqNo = cmd.getAckSeqNo();
        this.ackCode = cmd.getAckCode();
        this.ackParams = cmd.getAckParams();
    }

    public int jtInitMsgId() {
        return JTUtils.hexToMsgId(initMsgId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TermCmdStateChanged.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("id='" + id + "'")
                .add("externalId='" + externalId + "'")
                .add("reqTm=" + reqTm)
                .add("status=" + status)
                .add("tm=" + tm)
                .add("initMsgId='" + initMsgId + "'")
                .add("subCmdTyp='" + subCmdTyp + "'")
                .add("msgSn=" + msgSn)
                .add("simNo='" + simNo + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("ackMsgId='" + ackMsgId + "'")
                .add("ackSeqNo=" + ackSeqNo)
                .add("ackCode=" + ackCode)
                .add("ackParams=" + ackParams)
                .toString();
    }
}
