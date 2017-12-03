package io.mauth.fakefood.config;

import io.mauth.fakefood.services.SpooledMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by rahulb on 2/12/17.
 */
@ConditionalOnExpression("'${enable.scheduling}'=='true'")
@Component
public class JobRunnerConfig {

    @Autowired
    private SpooledMailService spooledMailService;

    @Scheduled(fixedRate = 1000)
    public void sendUnsentMails(){
        spooledMailService.sendUnsentMails();
    }

}
