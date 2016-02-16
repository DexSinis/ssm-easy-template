package com.github.ichenkaihua.model;

import javax.persistence.*;

@Table(name = "ofChatLogs")
public class Ofchatlogs {
    @Column(name = "MESSAGEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageid;

    @Column(name = "SESSIONJID")
    private String sessionjid;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "CREATEDATE")
    private String createdate;

    @Column(name = "LENGTH")
    private Integer length;

    @Column(name = "STATE")
    private Integer state;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DETAIL")
    private String detail;

    /**
     * @return MESSAGEID
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * @param messageid
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * @return SESSIONJID
     */
    public String getSessionjid() {
        return sessionjid;
    }

    /**
     * @param sessionjid
     */
    public void setSessionjid(String sessionjid) {
        this.sessionjid = sessionjid;
    }

    /**
     * @return SENDER
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return RECEIVER
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return CREATEDATE
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    /**
     * @return LENGTH
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @return STATE
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return CONTENT
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return DETAIL
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}