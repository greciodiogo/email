package com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender eMailSender;
    
    @Autowired
    private EmailRepository emailRepository;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @SuppressWarnings("finally")
    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        try {
            emailModel.setSendDateTime(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            eMailSender.send(message);


            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            // TODO: handle exception
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally{
            return emailRepository.save(emailModel);
        }
    }
}
