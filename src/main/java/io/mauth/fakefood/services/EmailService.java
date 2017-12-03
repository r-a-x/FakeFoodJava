package io.mauth.fakefood.services;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by rahulb on 1/12/17.
 */
public interface EmailService {
    void sendSimpleMessage(String from,
                           String to,
                           String subject,
                           String text);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String ...templateArgs);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String[] images,
                                   String[] names);

    String textFromTemplate(String textTemplate,String ... templateArgs);
}
