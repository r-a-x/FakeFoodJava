package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import io.mauth.fakefood.model.Company;
import io.mauth.fakefood.model.ProductCompanyMapping;
import io.mauth.fakefood.repo.*;
import io.mauth.fakefood.util.Constants;
import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.List;
import java.util.Map;

@Service("spooledMailService")
@Transactional
@Loggable
public class SpooledMailServiceImpl implements SpooledMailService {

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuditRepo auditRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private FlavourRepo flavourRepo;

    @Autowired
    private ProductCompanyMappingRepo productCompanyMappingRepo;

    @Override
    public List<Audit> getUnsentMails() {
        return auditRepo.findByStatus(RequestStatus.PENDING);
    }

    @Override
    public List<Audit> getFailedMails() {
        return auditRepo.findByStatus(RequestStatus.FAILED);
   }

    public Audit sendSpooledMail(Audit audit) {

        Company company = companyRepo.findById(audit.getCompanyId());
        String to = company.getEmail();
        to="bansal.rahul14@gmail.com";
        try {

            Map<String,Object> mp = new HashedMap();
            mp.put("product",audit.getName());
            String subject = VelocityEngineUtils.mergeTemplateIntoString(
                    this.velocityEngine,
                    Constants.SUBJECT_PATH,
                    "UTF-8",
                    mp);

//          The name for the product will be retrieved from this place, and it will be used to do some thing special
            ProductCompanyMapping productCompanyMapping = productCompanyMappingRepo.findByProductIdAndCompanyId(audit.getProductId(),audit.getCompanyId());
            Map<String,Object> params = new HashedMap();
            params.put("name",productCompanyMapping.getName());
            params.put("company",company.getName());
            params.put("size",audit.getSize());
//            Flavours flavours = flavourRepo.findByFlavour( audit.getFlavour());
            params.put("flavour",audit.getFlavour());
            params.put("placeOfPurchase",audit.getPlaceOfPurchase());
            params.put("lotNumber",audit.getLotNumber());
            params.put("expirationCode",audit.getExpirationDate().toString());
            params.put("barCode",audit.getBarCode());
            params.put("androidId",getMailId(audit));

            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    this.velocityEngine,
                    Constants.BODY_PATH,
                    "UTF-8",
                    params);


            String[] imagesPath = {
                    fileRepo.findByName(audit.getFrontCanisterImageName()).getPath(),
                    fileRepo.findByName(audit.getBackCanisterImageName()).getPath(),
                    fileRepo.findByName(audit.getLogoImageName()).getPath()
            };

            String[] names= {"frontimage.jpg","backimage.jpg","logoimage.jpg"};
            emailService.sendMessageWithAttachment(to,subject,text,imagesPath,
                    names);
            audit.setStatus(RequestStatus.SUBMITTED);

        } catch (Exception e) {
            audit.setStatus(RequestStatus.FAILED);
        }

        auditRepo.save(audit);
        return audit;
    }

    @Override
    public void sendUnsentMails() {
        List<Audit> unsentMails = getUnsentMails();
        unsentMails.forEach(this::sendSpooledMail);
    }

    private String getMailId(Audit audit){
        return audit.getAndroidId()+":"+audit.getId();
    }
}
