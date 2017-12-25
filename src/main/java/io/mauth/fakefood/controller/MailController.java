package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.MailRepsonseDto;
import io.mauth.fakefood.services.MailReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by rahulb on 23/12/17.
 */
@RestController
public class MailController {

    @Autowired
    private MailReaderService mailReaderService;


    @RequestMapping(value = "/mail",method = RequestMethod.POST)
    public void mailHook(@RequestBody String mailRepsonseRaw) throws UnsupportedEncodingException {
        MailRepsonseDto mailRepsonseDto = new MailRepsonseDto(mailRepsonseRaw);
        mailReaderService.processMail(mailRepsonseDto);
    }
//[["X-Mailgun-Incoming", "Yes"], ["X-Envelope-From", "<bansal.rahul14@gmail.com>"], ["Received", "from mail-qk0-f172.google.com (mail-qk0-f172.google.com [209.85.220.172]) by mxa.mailgun.org with ESMTP id 5a3e7c05.7f3df845fb70-smtp-in-n01; Sat, 23 Dec 2017 15:53:41 -0000 (UTC)"], ["Received", "by mail-qk0-f172.google.com with SMTP id u184so37963571qkd.6        for <admin@mg.mauth.io>; Sat, 23 Dec 2017 07:53:41 -0800 (PST)"], ["Dkim-Signature", "v=1; a=rsa-sha256; c=relaxed/relaxed;        d=gmail.com; s=20161025;        h=mime-version:in-reply-to:references:from:date:message-id:subject:to;        bh=HT84te/Z5nYXONtbG4zi++hjLdOo90X18ctvsFtgFdE=;        b=ro84lgvjjx4qLqGkHfS9wbUilTvDSqV5GPysEyg0zzeO3fR8HiD7epMEZ8RZlnC06x         rW8hA3aeF4r04QunxwODSZWUgBa4cePGUatGBXrU3px+gTUQU1iVOu9NknaAQB0Rro7k         0zrmPePKfH//0/zc5eA/hbFuycy9Azrovh0VrKLWjuMzi9RGnyxgnFarnriGnR6QyTif         AiixlI/d7KHJEqDJ83JcgLIy0ipxobvdgTSI/WCzsHh9CjNkTOJ00bQ3WkI4OxJlQYhU         eptRlfz/totZB8+WZMsdw2VWZBJfBG4gPJTMIhkEMjTqB5CuTHgc5aIGkWGHHWWn76zL         1N/g=="], ["X-Google-Dkim-Signature", "v=1; a=rsa-sha256; c=relaxed/relaxed;        d=1e100.net; s=20161025;        h=x-gm-message-state:mime-version:in-reply-to:references:from:date         :message-id:subject:to;        bh=HT84te/Z5nYXONtbG4zi++hjLdOo90X18ctvsFtgFdE=;        b=R+w9fMqq6hLLrGmp500O1Ts56F0S9rEN8mBjFdP8EQk/B7gkN4qwApJGEzdkIaBQih         6xRWhZar24DTQLHVCgannFN6DuyJzfyxbpzaLOWuQV/dVSgOIUdecryGsRslE3IH5xcu         JdiXY/D8EbOMSXfoeiJurocH0FJ6JfhrDFJeSpyr6ZHq8pTe8vZs+cC07hsL2qLSP2DD         sQZjNamiI29KO1HmOjvIzzCcHj3Q7c48D5P7fl/S0psdTLwajc/Wwbn5qwPAJSbGYOdK         1rt3Gb/gs8rzoBhyP8qFk0mjlR19BHXrCkFLOL3cj5L5qX6ihdsGO9LlSU+f19ItXFf1         NK8g=="], ["X-Gm-Message-State", "AKGB3mJn9wIv6SlhCBdHxqQmDy10a2+qClyfEuglomv6IiM2fpFgirI6\ta5I4AVtAyFsvdFyIKXGYLhWATY6lfKBS43xFWKKV5g=="], ["X-Google-Smtp-Source", "ACJfBotwqeXkQQHK2UG+VzphvCvzrCruJAbDGAhuLXib81HtkgBTn8YAKqd1u6/PgjEdBxDsbOlJkkDsJcsFKV0dxXM="], ["X-Received", "by 10.55.24.148 with SMTP id 20mr24447628qky.348.1514044420599; Sat, 23 Dec 2017 07:53:40 -0800 (PST)"], ["Mime-Version", "1.0"], ["Received", "by 10.140.44.69 with HTTP; Sat, 23 Dec 2017 07:53:40 -0800 (PST)"], ["In-Reply-To", "<20171223154830.41091.E783E82A3285749D@mg.mauth.io>"], ["References", "<20171223154830.41091.E783E82A3285749D@mg.mauth.io>"], ["From", "Rahul Bansal <bansal.rahul14@gmail.com>"], ["Date", "Sat, 23 Dec 2017 21:23:40 +0530"], ["Message-Id", "<CAFSvgQMjgOy4MQTkV_+OQ0UvrStvSkvfLQfoBUdCCGY=fBpvSg@mail.gmail.com>"], ["Subject", "Re: Request for Testing the authenticity of Optimum Nutrition (ON) 100% Whey Gold Standard"], ["To", "Excited User <admin@mg.mauth.io>"], ["Content-Type", "multipart/alternative; boundary=\"001a11441004dd36a2056103efbf\""]]
}
