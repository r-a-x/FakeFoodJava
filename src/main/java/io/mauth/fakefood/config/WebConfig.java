package io.mauth.fakefood.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

/**
 * Created by rahulb on 22/11/17.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Value("${smtp.pass}")
    private String smtpPass;

    @Value("${smtp.port}")
    private int smtpPort;

    @Value("${smtp.host}")
    private String smtpHost;

    @Value("${smtp.useSsl}")
    private String smtpUseSsl;

    @Value("${smtp.user}")
    private String smtpUser;

    @Value("${smtp.from}")
    private String smtpFrom;

    @Value("${smtp.to}")
    private String smtpTo;

    @Value("${smtp.subject}")
    private String smtpSubject;

    @Value("${smtp.debug}")
    private String debug;


    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(smtpHost);
        mailSender.setPort(smtpPort);

        mailSender.setUsername(smtpUser);
        mailSender.setPassword(smtpPass);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", debug);
        props.put("mail.isSSL","true");
        return mailSender;
    }

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:\n%s\n");
        return message;
    }

    @Bean
    public VelocityEngine getVelocityEngine(){
        Properties p = new Properties();
        p.setProperty("file.resource.loader.path", "src/main/resources/templates");
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(p);
        return velocityEngine;
    }
}
