package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rahulb on 20/12/17.
 */


@Entity
@DynamicUpdate
@Table(name = "spooled_mails")
public class SpooledMail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name ="audit_id")
    private Long auditId;

    @Column( name = "is_sent")
    private Boolean isSent;

    @Column( name = "is_failed")
    private Boolean isFailed;

    @Column( name = "failure_case")
    private String failureCause;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="message_id")
    private String messageId;

    @Column(name = "message")
    private String message;

    public SpooledMail() {
    }

    public SpooledMail(Long auditId, Boolean isSent, Boolean isFailed, String failureCause, String messageId, String message) {
        this.auditId = auditId;
        this.isSent = isSent;
        this.isFailed = isFailed;
        this.failureCause = failureCause;
        createdOn = new Date();
        this.messageId = messageId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public Boolean getFailed() {
        return isFailed;
    }

    public void setFailed(Boolean failed) {
        isFailed = failed;
    }

    public String getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
