package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import io.mauth.fakefood.model.Company;
import io.mauth.fakefood.repo.AuditRepo;
import io.mauth.fakefood.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by rahulb on 3/12/17.
 */
@Service
@Loggable
public class MailReaderService {

    @Autowired
    private AuditRepo auditRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Value("${smtp.pass}")
    private String pass;

    @Value("${smtp.user}")
    private String user;

    @Value("${imap.host}")
    private String host;

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

//  Need to Figure out the way the messages are structured and to which way they are sent. Based on
//  that decision need to be taken. If the message

    private Boolean isOriginal(String text){
        return text.toLowerCase().contains("original") || text.toLowerCase().contains("authentic");
    }

    private Boolean isFake(String text){
        return text.toLowerCase().contains("fake") || text.toLowerCase().contains("duplicate") || text.contains("unauthentic");
    }


    public void processEmails() throws IOException, MessagingException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(System.getProperty("user.dir")+"/"+ "src/main/resources/readmail.properties")));
        Session session = Session.getDefaultInstance(properties,null);
        Store store = session.getStore("imaps");
        store.connect(host,user,pass);
        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN),false));


        for( Message msg : messages){

            String text = getTextFromMessage(msg);
            String androidId = getAndroidId(text);

            String companyMail = sendersName(msg);
            Company company = companyRepo.findByEmail(companyMail);

            Audit audit =  auditRepo.findByAndroidIdAndCompanyId(androidId,company.getId());

            if ( isFake(text)) {
                    audit.setStatus(RequestStatus.FAKE);
            }
            else if ( isOriginal(text)){
                    audit.setStatus(RequestStatus.ORIGINAL);
            }
            else{
                    audit.setStatus(RequestStatus.UNABLE_TO_DETERMINE);
            }
            auditRepo.save(audit);

            msg.setFlag(Flags.Flag.SEEN,true);
        }
        inbox.close(false);

    }

    private String getAndroidId(String text){
        int s = text.indexOf("androidId:-");
        int l = text.lastIndexOf("!");
        return text.substring(s+"androidId:-".length(),l);
    }

    private String sendersName(Message message) throws MessagingException {
        Address[] address = message.getFrom();
        String info= address[0].toString();
        return info.substring( info.indexOf("<"),info.indexOf(">") );
    }
}
