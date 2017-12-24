package io.mauth.fakefood.services;


import io.mauth.fakefood.dto.MailGunResponseDto;

public interface MailGunService {

    MailGunResponseDto sendEmail(String from, String to, String subject, String html);

    MailGunResponseDto sendMailWithAttachment(String from, String to, String subject, String html, String frontImagePath, String backImagePath, String logoImagePath);
}
