package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.MailRepsonseDto;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import io.mauth.fakefood.model.MailGunMail;
import io.mauth.fakefood.model.SpooledMail;
import io.mauth.fakefood.repo.AuditRepo;
import io.mauth.fakefood.repo.MailGunMailRepo;
import io.mauth.fakefood.repo.SpooledMailsRepo;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 * Created by rahulb on 3/12/17.
 */
@Service
@Loggable
public class MailReaderService {

    @Autowired
    private AuditRepo auditRepo;

    @Autowired
    private SpooledMailsRepo spooledMailsRepo;

    @Autowired
    private MailGunMailRepo mailGunMailRepo;

    private Logger logger = Logger.getLogger("MailReaderService.class");
    private Boolean isOriginal(String text){
        if ( text == null)
            return false;
        return text.toLowerCase().contains("original") || text.toLowerCase().contains("authentic");
    }

    private Boolean isFake(String text){
        if ( text == null)
            return false;
        return text.toLowerCase().contains("fake") || text.toLowerCase().contains("duplicate") || text.contains("unauthentic");
    }


    private String getMailId(String text){
        int s = text.indexOf("androidId:-");
        int l = text.lastIndexOf("!");
        if ( s==- 1 )
            return null;
        return text.substring(s+"androidId:-".length(),l);
    }

    private String sendersName(Message message) throws MessagingException {
        Address[] address = message.getFrom();
        String info= address[0].toString();
        return info.substring( info.indexOf("<")+1,info.indexOf(">") );
    }

    private String getAndroidIdFromMailId(String mailId){
        return mailId.substring(0,mailId.lastIndexOf(":"));
    }
    private Long getAuditIdFromMailId(String mailId){
        int mailIdidx = mailId.lastIndexOf(":");
        return Long.valueOf(mailId.substring(mailIdidx+1,mailId.length()));

    }

    public void processMail(MailRepsonseDto mailRepsonseDto) {

        MailGunMail mailGunMail = mailRepsonseDto.toMailGunMail();
        mailGunMailRepo.save(mailGunMail);

        updateStatus(mailRepsonseDto);

        mailGunMail.setUsed(Boolean.TRUE);
        mailGunMailRepo.save(mailGunMail);
    }

    @Transactional
    private  void updateStatus(MailRepsonseDto mailRepsonseDto){

        SpooledMail spooledMail = spooledMailsRepo.findByMessageId(mailRepsonseDto.getInReplyTo());

        if ( spooledMail == null) {
            logger.log(Priority.toPriority(Priority.WARN_INT),"The spooled Mail is the MailReaderService is not present for the id"+mailRepsonseDto.getMessageId());
            return;
        }
        Audit audit = auditRepo.findById(spooledMail.getAuditId());
        if ( audit ==  null ){
            logger.log(Priority.toPriority(Priority.WARN_INT),"The audit corresponding for the spooledMail id  "  + spooledMail.getId() + " is not present" );
            return;
        }

        if ( isFake( mailRepsonseDto.getStrippedText()))
            audit.setStatus(RequestStatus.FAKE);
        else if ( isOriginal(mailRepsonseDto.getStrippedText()))
            audit.setStatus(RequestStatus.ORIGINAL);
        else
            audit.setStatus(RequestStatus.UNABLE_TO_DETERMINE);
    }
}
