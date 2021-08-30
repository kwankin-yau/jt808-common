/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types;

public class JT808PhoneBookEntry implements Cloneable {

    private byte typ;
    private String phoneNo;
    private String contacts;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public JT808PhoneBookEntry clone() {
        try {
            return (JT808PhoneBookEntry) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "JT808PhoneBookEntry{" +
                "typ=" + typ +
                ", phoneNo='" + phoneNo + '\'' +
                ", contacts='" + contacts + '\'' +
                '}';
    }
}
