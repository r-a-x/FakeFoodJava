package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by rahulb on 1/12/17.
 */
@Service
@Loggable
public class EmailServiceImpl  implements EmailService{

    @Autowired
    public JavaMailSender emailSender;


    public void sendSimpleMessage(String from,String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               SimpleMailMessage template,
                                               String ...templateArgs) {
        String text = String.format(template.getText(), templateArgs);
        sendSimpleMessage(null,to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to,
                                          String subject,
                                          String text,
                                          String[]images,
                                          String[] names) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("admin@mauth.io");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            assert (images.length == names.length);

            for(int i=0;i<images.length;i++){
                helper.addAttachment(names[i], new File(images[i]));
            }

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String textFromTemplate(String textTemplate, String... templateArgs) {
//        return String.format(textTemplate.getText(), templateArgs);
        return "Not Implemented yet";
    }
}
