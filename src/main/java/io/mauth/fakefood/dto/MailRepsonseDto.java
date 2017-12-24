package io.mauth.fakefood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.mauth.fakefood.model.MailGunMail;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahulb on 23/12/17.
 */
public class MailRepsonseDto implements Serializable {
//    private String domain;
//    private String recipient;
//    private String sender;
//    private String from;
//    private String subject;
//    private String bodyPlain;
//    private String strippedText;
//    private String strippedSignature;
//    private String bodyHtml;
//    private String strippedHtml;
//    private String attachments;
//    private String messageUrl;
//    private Long timeStamp;
//    private String token;
//    private String signature;
//    private String messageHeaders;
//    private String conentIdMap;


    @JsonProperty("Content-Type")
    private String contentType;
    @JsonProperty("Message-Id")
    private String messageId;
    @JsonProperty("Mime-Version")
    private String mimeVersion;
    @JsonProperty("to")
    private String to;
    @JsonProperty("X-Envelope-From")
    private String xEnvelopeFrom;
    @JsonProperty("X-Mailgun-Incoming")
    private String xMailgunIncoming;
    @JsonProperty("X-Originating-Ip")
    private String xOriginatingIp;
    @JsonProperty("body-html")
    private String bodyHtml;
    @JsonProperty("body-plain")
    private String bodyPlain;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("from")
    private String from;
    @JsonProperty("message-headers")
    private String messageHeaders;
    @JsonProperty("message-url")
    private String messageUrl;
    private String recipient;
    private String sender;
    @JsonProperty("signature")
    private String signature;
    @JsonProperty("stripped-html")
    private String strippedHtml;
    @JsonProperty("stripped-signature")
    private String strippedSignature;
    @JsonProperty("stripped-text")
    private String strippedText;
    private String subject;
    private Long timestamp;
    private String token;
    private String inReplyTo;


    public MailRepsonseDto() {
    }

    public MailRepsonseDto(String contentType, String from, String messageId, String mimeVersion, String subject, String to, String xEnvelopeFrom, String xMailgunIncoming, String xOriginatingIp, String bodyHtml, String bodyPlain, String domain, String from1, String messageHeaders, String messageUrl, String recipient, String sender, String signature, String strippedHtml, String strippedSignature, String strippedText, String subject1, Long timestamp, String token) {
        this.contentType = contentType;
        this.from = from;
        this.messageId = messageId;
        this.mimeVersion = mimeVersion;
        this.subject = subject;
        this.to = to;
        this.xEnvelopeFrom = xEnvelopeFrom;
        this.xMailgunIncoming = xMailgunIncoming;
        this.xOriginatingIp = xOriginatingIp;
        this.bodyHtml = bodyHtml;
        this.bodyPlain = bodyPlain;
        this.domain = domain;
        this.from = from1;
        this.messageHeaders = messageHeaders;
        this.messageUrl = messageUrl;
        this.recipient = recipient;
        this.sender = sender;
        this.signature = signature;
        this.strippedHtml = strippedHtml;
        this.strippedSignature = strippedSignature;
        this.strippedText = strippedText;
        this.subject = subject1;
        this.timestamp = timestamp;
        this.token = token;
    }

    public MailRepsonseDto(String mailRepsonseRaw) throws UnsupportedEncodingException {
        Map<String,String> mp = new HashMap<>();
        String resp[]=mailRepsonseRaw.split("&");
        for (String res :resp){
            mp.put(res.split("=")[0], URLDecoder.decode( res.split("=") [1],"UTF-8" ));
        }
        this.setContentType(mp.get("Content-Type"));
        this.setMessageId(mp.get("Message-Id"));
        this.setMimeVersion(mp.get("Mime-Version"));
        this.setTo(mp.get("to"));
        this.setxEnvelopeFrom(mp.get("X-Envelope-From"));
        this.setxMailgunIncoming(mp.get("X-Mailgun-Incoming"));
        this.setxOriginatingIp(mp.get("X-Originating-Ip"));
        this.setBodyHtml(mp.get("body-html"));
        this.setBodyPlain(mp.get("body-plain"));
        this.setDomain(mp.get("domain"));
        this.setFrom(mp.get("from"));
        this.setMessageHeaders(mp.get("message-headers"));
        this.setMessageUrl(mp.get("message-url"));
        this.setRecipient(mp.get("recipent"));
        this.setSender(mp.get("sender"));
        this.setSignature(mp.get("signature"));
        this.setStrippedHtml(mp.get("stripped-html"));
        this.setStrippedSignature(mp.get("stripped-signature"));
        this.setStrippedText(mp.get("stripped-text"));
        this.setSubject(mp.get("subject"));
        this.setTimestamp(Long.valueOf(mp.get("timestamp")));
        this.setToken(mp.get("token"));
        this.inReplyTo = parseOldReferences(this.getMessageHeaders());


    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public MailGunMail toMailGunMail(){
        return new MailGunMail(this.getContentType(),
                this.getMessageId(),
                this.getMimeVersion(),
                this.getTo(),
                this.getxEnvelopeFrom(),
                this.getxMailgunIncoming(),
                this.getxOriginatingIp(),
                this.getBodyHtml(),
                this.getBodyPlain(),
                this.getDomain(),
                this.getFrom(),
                this.getMessageHeaders(),
                this.getMessageUrl(),
                this.getRecipient(),
                this.getSender(),
                this.getSignature(),
                this.getStrippedHtml(),
                this.getStrippedSignature(),
                this.getStrippedText(),
                this.getSubject(),
                new Date(this.getTimestamp()),
                this.getToken(),
                this.getInReplyTo()
                );
    }

    private String parseInReplyTo(String messageHeaders){
        return  messageHeaders.split("\"In-Reply-To\",")[1].split("]")[0].trim().split("\"")[1];
    }

    private String parseOldReferences(String messageHeaders){
        return messageHeaders.split("\"References\"")[1].split("]")[0].split(".io>")[0].split("\"")[1]+".io>";
    }
// [["X-Mailgun-Incoming", "Yes"], ["X-Envelope-From", "<bansal.rahul14@gmail.com>"], ["Received", "from mail-qt0-f181.google.com (mail-qt0-f181.google.com [209.85.216.181]) by mxa.mailgun.org with ESMTP id 5a3e83ac.7f28c55289b0-smtp-in-n02; Sat, 23 Dec 2017 16:26:20 -0000 (UTC)"], ["Received", "by mail-qt0-f181.google.com with SMTP id g9so39499561qth.9        for <admin@mg.mauth.io>; Sat, 23 Dec 2017 08:26:20 -0800 (PST)"], ["Dkim-Signature", "v=1; a=rsa-sha256; c=relaxed/relaxed;        d=gmail.com; s=20161025;        h=mime-version:in-reply-to:references:from:date:message-id:subject:to;        bh=SnJm05bywG9zmKjr5tQ9KqDPY2TUvoevN2k46Mpa/Zk=;        b=FTM07TvxXWsYUxDmQssaURat+DIQa1gtIqIQf+5dVx2SAo9VLj83UiFjkuGj1kNYST         51BEPozMJ9QiEwcJb1ipbXtht1kpn28phnqMWJUjmDJ6qGuzia/6gLJUeWvj1zr2rgYw         rGyYXEjGdyES3bqCoV8baVhL6wgS5drqYE57rkKN0Y0grUTFsTtPeNH5yWz083R1vZtT         7ZfQe+w8VeRZTeWFxwzMpjGLxdQAa/H72C3fUzkEOzNo6b/k6ZETzzCJ8mcg/BMJj7yL         CgxjlwGbU94B+ri6WCFh/aTcCZ4prHSg2Z6lJg1P9ipflGWPYMdDdROCzyrTIpjP7dvr         uNEA=="], ["X-Google-Dkim-Signature", "v=1; a=rsa-sha256; c=relaxed/relaxed;        d=1e100.net; s=20161025;        h=x-gm-message-state:mime-version:in-reply-to:references:from:date         :message-id:subject:to;        bh=SnJm05bywG9zmKjr5tQ9KqDPY2TUvoevN2k46Mpa/Zk=;        b=oSAX7vk6EtYXo2v7UzBetb7B1PimQaFRCNDgLW9eZR78HnvFIWD8HExE32mx2BjpAB         lnEnxrT8wuLdstjW218MpO+BhB8pNeu628nErqREmTIaodV48VKgieuzrAk+OyhqDKEt         162Ghb9rGI6dVwemOdV0DPPKG5bL1BcsXqqDQycj7pwzNeSiSPHuN9iS8gnelafKPXVt         bGvTOOAc8m/zQlUIwvldYTmz0hcBVhdvGKDS2WflFTu1mbRRnsKvIkBk1oKWXBsNmmTo         o3SJQjZF7Tbpf3S5UjL5vlR2JmgwL0IFIcdU0ANm3n23BSTKudzn1Y4Il7bYOFWVmmL8         Wy1g=="], ["X-Gm-Message-State", "AKGB3mLgQLyywrOXDo/GdVvsCOgKEF7GMPXn7YJWjgKv7aJd+oFQ0pZr\t+7Gcb6QHVDSoBtkmFwvgZMQJFqHn3El2q/eFk5rTDw=="], ["X-Google-Smtp-Source", "ACJfBovHHde9PZDYWw5s6AnAq+sIvIO+zt7T7VT+MvTzOSKB5zENgtlBcriXo4faIkvfYmeBsFuKr+/kXpd1pDcQMvk="], ["X-Received", "by 10.237.62.169 with SMTP id n38mr26326663qtf.42.1514046379612; Sat, 23 Dec 2017 08:26:19 -0800 (PST)"], ["Mime-Version", "1.0"], ["Received", "by 10.140.44.69 with HTTP; Sat, 23 Dec 2017 08:26:19 -0800 (PST)"], ["In-Reply-To", "<CAFSvgQMjgOy4MQTkV_+OQ0UvrStvSkvfLQfoBUdCCGY=fBpvSg@mail.gmail.com>"], ["References", "<20171223154830.41091.E783E82A3285749D@mg.mauth.io> <CAFSvgQMjgOy4MQTkV_+OQ0UvrStvSkvfLQfoBUdCCGY=fBpvSg@mail.gmail.com>"], ["From", "Rahul Bansal <bansal.rahul14@gmail.com>"], ["Date", "Sat, 23 Dec 2017 21:56:19 +0530"], ["Message-Id", "<CAFSvgQO6pgzkqzgaAyVpz9cPsRhu3G5Pbv9asBGNETkKW8eUQA@mail.gmail.com>"], ["Subject", "Re: Request for Testing the authenticity of Optimum Nutrition (ON) 100% Whey Gold Standard"], ["To", "Excited User <admin@mg.mauth.io>"], ["Content-Type", "multipart/alternative; boundary=\"001a113b5124a15e4305610464d7\""]]
}
