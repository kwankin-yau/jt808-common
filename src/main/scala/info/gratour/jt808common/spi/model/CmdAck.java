/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import com.google.gson.reflect.TypeToken;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;

import java.lang.reflect.Type;
import java.util.StringJoiner;

public class CmdAck {

    public static final Type TYPE = new TypeToken<CmdAck>(){}.getType();

    private String id;
    private String initiateMsgId;
    private String subCmdTyp;
    private String simNo;
    private long reqTm;
    private String plateNo;
    private int plateColor;
    private String ackMsgId;
    private Integer ackSeqNo;
    private long ackTm;
    private boolean ok;
    private Integer ackCode;
    private int cmdSrc;
    private JT808AckParams ackParams;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitiateMsgId() {
        return initiateMsgId;
    }

    public void setInitiateMsgId(String initiateMsgId) {
        this.initiateMsgId = initiateMsgId;
    }

    public int initiateMsgIdToInt() {
        if (initiateMsgId != null)
            return Integer.parseInt(initiateMsgId, 16);
        else
            return 0;
    }

    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getReqTm() {
        return reqTm;
    }

    public void setReqTm(long reqTm) {
        this.reqTm = reqTm;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * Get message id of the ack(not the initiate message id).
     * @return message id of the ack
     */
    public String getAckMsgId() {
        return ackMsgId;
    }

    public void setAckMsgId(String ackMsgId) {
        this.ackMsgId = ackMsgId;
    }

    public int ackMsgIdToInt() {
        if (ackMsgId != null)
            return Integer.parseInt(ackMsgId, 16);
        else
            return 0;
    }


    public Integer getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(Integer ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * Ack time in epoch millis.
     *
     * @return ack time in epoch millis.
     */
    public long getAckTm() {
        return ackTm;
    }

    public void setAckTm(long ackTm) {
        this.ackTm = ackTm;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public Integer getAckCode() {
        return ackCode;
    }

    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    public int getCmdSrc() {
        return cmdSrc;
    }

    public void setCmdSrc(int cmdSrc) {
        this.cmdSrc = cmdSrc;
    }

    public JT808AckParams getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CmdAck.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("initiateMsgId='" + initiateMsgId + "'")
                .add("subCmdTyp='" + subCmdTyp + "'")
                .add("simNo='" + simNo + "'")
                .add("reqTm=" + reqTm)
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("ackMsgId='" + ackMsgId + "'")
                .add("ackSeqNo=" + ackSeqNo)
                .add("ackTm=" + ackTm)
                .add("ok=" + ok)
                .add("ackCode=" + ackCode)
                .add("cmdSrc=" + cmdSrc)
                .add("ackParams=" + ackParams)
                .toString();
    }
}
