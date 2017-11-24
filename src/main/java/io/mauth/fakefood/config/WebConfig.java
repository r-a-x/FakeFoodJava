package io.mauth.fakefood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by rahulb on 22/11/17.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private ApplicationContext context;
//
////    @Value("${mailgun.api.user}")
//    private String mailgunApiUser;
//
////    @Value("${mailgun.api.key}")
//    private String mailgunApiKey;
//
//    @Bean(name = "mailgunRestTemplate")
//    public RestTemplate mailgunRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
//        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(mailgunApiUser, mailgunApiKey));
//        return restTemplate;
//    }
//
//    @Bean
//    public ClientHttpRequestFactory clientHttpRequestFactory() {
//        return new HttpComponentsClientHttpRequestFactory();
//    }
//
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
//        resolver.setFallbackPageable(new PageRequest(0, 20));
//        argumentResolvers.add(resolver);
//    }

}
