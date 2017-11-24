package io.mauth.fakefood.services;

import io.mauth.fakefood.dto.MailGunResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Transactional
public class MailGunServiceImpl implements MailGunService {

//    private static final String PATH_MESSAGES = "/messages";
//
//    private static final String PARAM_FROM = "from";
//    private static final String PARAM_TO = "to";
//    private static final String PARAM_SUBJECT = "subject";
//    private static final String PARAM_HTML = "html";
//
////    @Value("${mailgun.api.url}")
//    private String API_URL;
//
////    @Value("${mailgun.api.domain}")
//    private String API_DOMAIN;
//
//    private RestTemplate mailgunRestTemplate;
//
//    @Autowired
//    public MailGunServiceImpl(@Qualifier("mailgunRestTemplate") RestTemplate restTemplate) {
//        this.mailgunRestTemplate = restTemplate;
//    }
//
//    @Override
//    public MailGunResponseDto sendEmail(String from, String to, String subject, String html) {
//        URI targetUrl = UriComponentsBuilder.fromUriString(API_URL)
//                .path(API_DOMAIN)
//                .path(PATH_MESSAGES)
//                .build()
//                .toUri();
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add(PARAM_FROM, from);
//        map.add(PARAM_TO, to);
//        map.add(PARAM_SUBJECT, subject);
//        map.add(PARAM_HTML, html);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());
//
//        return mailgunRestTemplate.postForEntity(targetUrl, request, MailGunResponseDto.class).getBody();
//    }
//
//    private HttpHeaders getHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        return headers;
//    }
}
