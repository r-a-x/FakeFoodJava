package io.mauth.fakefood.controller;

import io.mauth.fakefood.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rahulb on 2/12/17.
 */
@RestController
public class TestController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/test/mail",method = RequestMethod.GET)
    public void testSendMail(){
        emailService.sendSimpleMessage("admin@mauth.io","bansal.rahul14@gmail.com","Testing the send Mail","Het Bro congrats on reciecing the message");
    }
}
