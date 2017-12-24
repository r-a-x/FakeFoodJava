package io.mauth.fakefood.config;

import io.mauth.fakefood.services.MailReaderService;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by rahulb on 22/11/17.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${smtp.debug}")
    private String debug;

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    @Bean
    public JavaMailSender getJavaMailSender() throws IOException {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.load(MailReaderService.class.getClassLoader().getResourceAsStream("readmail.properties"));
        mailSender.setUsername(properties.getProperty("mail.smtp.user"));
        mailSender.setPassword(properties.getProperty("mail.smtp.pass"));

        Properties props = mailSender.getJavaMailProperties();
        props.load(MailReaderService.class.getClassLoader().getResourceAsStream("readmail.properties"));
        return mailSender;
    }

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:\n%s\n");
        return message;
    }

    @Bean(name = "mailgunRestTemplate")
    public RestTemplate mailgunRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) throws IOException {
        Properties properties = new Properties();
        properties.load(WebConfig.class.getClassLoader().getResourceAsStream("readmail.properties"));
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(
                "api", properties.getProperty("mailgunApiKey")
        ));
        return restTemplate;
    }



    @Bean
    public VelocityEngine getVelocityEngine(){
        Properties p = new Properties();
        p.setProperty(RuntimeConstants.RESOURCE_LOADER,"classpath");
        p.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init(p);
        return velocityEngine;
    }
}
