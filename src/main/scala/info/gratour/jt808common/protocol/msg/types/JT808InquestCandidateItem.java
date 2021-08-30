/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

public class JT808InquestCandidateItem implements Cloneable {

    private short candidateId;
    private String candidate;

    public short getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(short candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    @Override
    public JT808InquestCandidateItem clone() {
        try {
            return (JT808InquestCandidateItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808MsgInquestCandidateItem{" +
                "candidateId=" + candidateId +
                ", candidate='" + candidate + '\'' +
                '}';
    }
}
