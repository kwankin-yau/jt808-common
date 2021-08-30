/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.JT808InquestCandidateItem;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.INQUEST_8302)
public class CP_8302_Inquest implements JT808CmdParams {
    private byte flags;
    private String question;
    private JT808InquestCandidateItem[] candidates;

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public JT808InquestCandidateItem[] getCandidates() {
        return candidates;
    }

    public void setCandidates(JT808InquestCandidateItem[] candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "CP_8302_Inquest{" +
                "flags=" + flags +
                ", question='" + question + '\'' +
                ", candidates=" + Arrays.toString(candidates) +
                '}';
    }

    public void assignFrom(CP_8302_Inquest source) {
        this.flags = source.flags;
        this.question = source.question;
        if (source.candidates != null) {
            this.candidates = new JT808InquestCandidateItem[source.candidates.length];
            for (int i = 0; i < this.candidates.length; i++)
                this.candidates[i] = source.candidates[i].clone();
        } else
            this.candidates = null;
    }

    @Override
    public CP_8302_Inquest clone() {
        CP_8302_Inquest r = new CP_8302_Inquest();
        r.assignFrom(this);
        return r;
    }
}
