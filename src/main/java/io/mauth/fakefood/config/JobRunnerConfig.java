package io.mauth.fakefood.config;

import io.mauth.fakefood.services.SpooledMailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by rahulb on 2/12/17.
 */
@Component
@ConditionalOnExpression("'${enable.scheduling}'=='true'")
public class JobRunnerConfig {

    private Logger logger =  Logger.getLogger("JobRunner");

    @Autowired
    private SpooledMailService spooledMailService;

    @Scheduled(fixedRate = 10000)
    public void sendUnsentMails(){
        spooledMailService.sendUnsentMails();
    }

}
