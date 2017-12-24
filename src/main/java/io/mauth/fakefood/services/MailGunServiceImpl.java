package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.MailGunResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
@Loggable
public class MailGunServiceImpl implements MailGunService {


    private static final String PATH_MESSAGES = "/messages";

    private static final String PARAM_FROM = "from";
    private static final String PARAM_TO = "to";
    private static final String PARAM_SUBJECT = "subject";
    private static final String PARAM_HTML = "html";
    private static final String PARAM_ATTACHMENT = "attachment";

    @Value("${mailgun.url}")
    private String API_URL;

    private RestTemplate mailgunRestTemplate;

    @Autowired
    public MailGunServiceImpl(@Qualifier("mailgunRestTemplate") RestTemplate restTemplate) {
        this.mailgunRestTemplate = restTemplate;
    }

    @Override
    public MailGunResponseDto sendEmail(String from, String to, String subject, String html) {
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
//        return mailgunRestTemplate.postForEntity(targetUrl, request, MailGunResponseDto.class).getBody();
        return null;
    }

    @Override
    public MailGunResponseDto sendMailWithAttachment(String from, String to, String subject, String html, String frontImagePath, String backImagePath, String logoImagePath){

        URI targetUrl = UriComponentsBuilder.fromUriString(API_URL).build().toUri();

        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();

        map.add(PARAM_FROM, from);
        map.add(PARAM_TO, to);
        map.add(PARAM_SUBJECT, subject);
        map.add(PARAM_HTML, html);
        map.add(PARAM_ATTACHMENT,new FileSystemResource(frontImagePath));
        map.add(PARAM_ATTACHMENT,new FileSystemResource(backImagePath));
        map.add(PARAM_ATTACHMENT,new FileSystemResource(logoImagePath));


        HttpEntity<MultiValueMap<String,Object>> request = new HttpEntity<>(map,getHeaders());
        return mailgunRestTemplate.postForObject(targetUrl,request,MailGunResponseDto.class);

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }
}
//
//curl -s --user 'api:f21340adb70adf58b9a00e21cc8ce25f' \
//        https://api.mailgun.net/v3/mg.mauth.io/messages \
//        -F from='Excited User <admin@mg.mauth.io>' \
//        -F to='bansal.rahul14@gmail.com' \
//        -F subject='Hello' \
//        -F text='Testing some Mailgun awesomness! bc' \
//        --form-string html='<html>HTML version of the body</html>' \
//        -F attachment=@files/00GP5XYQJHGKQB4DX6.jpg \
//        -F attachment=@files/C3P7EQ2SSPHNSZT3NB.jpg