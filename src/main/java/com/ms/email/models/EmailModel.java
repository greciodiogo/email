package com.ms.email.models;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ms.email.enums.StatusEmail;

import jakarta.persistence.*;


@Entity
@Table(name = "TB_EMAILS")
public class EmailModel implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateTime;
    private StatusEmail StatusEmail;
    

    public UUID getEmailId() {
        return this.emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return this.emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return this.emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateTime() {
        return this.sendDateTime;
    }

    public void setSendDateTime(LocalDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public StatusEmail getStatusEmail() {
        return this.StatusEmail;
    }

    public void setStatusEmail(StatusEmail StatusEmail) {
        this.StatusEmail = StatusEmail;
    }
}
