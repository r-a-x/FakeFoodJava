package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rahulb on 23/12/17.
 */

@Entity
@DynamicUpdate
@Table(name = "mail_response")
public class MailGunMail implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id; // It will be stored in the local db, just tells the request made by the user

    @Column(name = "content_type")
    private String contentType;
    @Column(name = "message_id")
    private String messageId;
    @Column(name = "mime_version")
    private String mimeVersion;
    @Column(name = "mail_to")
    private String to;
    @Column(name = "x_envelope_from")
    private String xEnvelopeFrom;
    @Column(name = "x_mailgun_incoming")
    private String xMailgunIncoming;
    @Column(name = "x_originating_ip")
    private String xOriginatingIp;
    @Column(name = "body_html")
    private String bodyHtml;
    @Column(name = "body_plain")
    private String bodyPlain;
    @Column(name = "domain")
    private String domain;
    @Column(name = "mail_from")
    private String from;
    @Column(name = "message_headers")
    private String messageHeaders;
    @Column(name = "message_url")
    private String messageUrl;
    @Column(name = "recipient")
    private String recipient;
    @Column(name = "sender")
    private String sender;
    @Column(name = "signature")
    private String signature;
    @Column(name = "stripped_html")
    private String strippedHtml;
    @Column(name = "stripped_signature")
    private String strippedSignature;
    @Column(name = "stripped_text")
    private String strippedText;
    @Column(name = "subject")
    private String subject;
    @Column(name = "time")
    private Date timestamp;
    @Column(name = "token")
    private String token;
    @Column(name = "is_used")
    private Boolean isUsed;
    @Column(name = "in_reply_to")
    private String inReplyTo;
    @Column(name = "created_on")
    private Date created_on;


    public MailGunMail() {
    }

    public MailGunMail(String contentType, String messageId, String mimeVersion, String to, String xEnvelopeFrom, String xMailgunIncoming, String xOriginatingIp, String bodyHtml, String bodyPlain, String domain, String from, String messageHeaders, String messageUrl, String recipient, String sender, String signature, String strippedHtml, String strippedSignature, String strippedText, String subject, Date timestamp, String token,String inReplyTo) {
        this.contentType = contentType;
        this.messageId = messageId;
        this.mimeVersion = mimeVersion;
        this.to = to;
        this.xEnvelopeFrom = xEnvelopeFrom;
        this.xMailgunIncoming = xMailgunIncoming;
        this.xOriginatingIp = xOriginatingIp;
        this.bodyHtml = bodyHtml;
        this.bodyPlain = bodyPlain;
        this.domain = domain;
        this.from = from;
        this.messageHeaders = messageHeaders;
        this.messageUrl = messageUrl;
        this.recipient = recipient;
        this.sender = sender;
        this.signature = signature;
        this.strippedHtml = strippedHtml;
        this.strippedSignature = strippedSignature;
        this.strippedText = strippedText;
        this.subject = subject;
        this.timestamp = timestamp;
        this.token = token;
        this.created_on = new Date();
        this.inReplyTo = inReplyTo;
        this.isUsed=Boolean.FALSE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMimeVersion() {
        return mimeVersion;
    }

    public void setMimeVersion(String mimeVersion) {
        this.mimeVersion = mimeVersion;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getxEnvelopeFrom() {
        return xEnvelopeFrom;
    }

    public void setxEnvelopeFrom(String xEnvelopeFrom) {
        this.xEnvelopeFrom = xEnvelopeFrom;
    }

    public String getxMailgunIncoming() {
        return xMailgunIncoming;
    }

    public void setxMailgunIncoming(String xMailgunIncoming) {
        this.xMailgunIncoming = xMailgunIncoming;
    }

    public String getxOriginatingIp() {
        return xOriginatingIp;
    }

    public void setxOriginatingIp(String xOriginatingIp) {
        this.xOriginatingIp = xOriginatingIp;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getBodyPlain() {
        return bodyPlain;
    }

    public void setBodyPlain(String bodyPlain) {
        this.bodyPlain = bodyPlain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessageHeaders() {
        return messageHeaders;
    }

    public void setMessageHeaders(String messageHeaders) {
        this.messageHeaders = messageHeaders;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getStrippedHtml() {
        return strippedHtml;
    }

    public void setStrippedHtml(String strippedHtml) {
        this.strippedHtml = strippedHtml;
    }

    public String getStrippedSignature() {
        return strippedSignature;
    }

    public void setStrippedSignature(String strippedSignature) {
        this.strippedSignature = strippedSignature;
    }

    public String getStrippedText() {
        return strippedText;
    }

    public void setStrippedText(String strippedText) {
        this.strippedText = strippedText;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }
}
