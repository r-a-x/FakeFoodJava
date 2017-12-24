package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.MailGunResponseDto;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import io.mauth.fakefood.model.Company;
import io.mauth.fakefood.model.ProductCompanyMapping;
import io.mauth.fakefood.model.SpooledMail;
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
    private ResellersRepo resellersRepo;

    @Autowired
    private ProductCompanyMappingRepo productCompanyMappingRepo;

    @Autowired
    private SpooledMailsRepo spooledMailsRepo;

    @Autowired
    private MailGunService mailGunService;

    @Override
    public List<Audit> getUnsentMails() {
        return auditRepo.findByStatus(RequestStatus.PENDING);
    }

    @Override
    public List<Audit> getFailedMails() {
        return auditRepo.findByStatus(RequestStatus.FAILED);
   }

    private final static String TEMPLATE_PATH="templates/";

    public Audit sendSpooledMail(Audit audit) {

        Company company = companyRepo.findById(audit.getCompanyId());
        String to = company.getEmail();
        try {
            ProductCompanyMapping productCompanyMapping = productCompanyMappingRepo.findByProductIdAndCompanyId(audit.getProductId(),audit.getCompanyId());
            Map<String,Object> mp = new HashedMap();
            mp.put("product",productCompanyMapping.getName());
            String subject = VelocityEngineUtils.mergeTemplateIntoString(
                    this.velocityEngine,
                    TEMPLATE_PATH+Constants.SUBJECT_PATH,
                    "UTF-8",
                    mp);

//          The name for the product will be retrieved from this place, and it will be used to do some thing special

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
            params.put("link",resellersRepo.findByName(trimBraces(audit.getPlaceOfPurchase())).getUrl());

            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    this.velocityEngine,
                    TEMPLATE_PATH+Constants.BODY_PATH,
                    "UTF-8",
                    params);

            String frontImagePath  = fileRepo.findByName(audit.getFrontCanisterImageName()).getPath();
            String backImagePath =  fileRepo.findByName(audit.getBackCanisterImageName()).getPath();
            String logoImagePath = fileRepo.findByName(audit.getLogoImageName()).getPath();

            String[] imagesPath = {
                    fileRepo.findByName(audit.getFrontCanisterImageName()).getPath(),
                    fileRepo.findByName(audit.getBackCanisterImageName()).getPath(),
                    fileRepo.findByName(audit.getLogoImageName()).getPath()
            };

            String[] names= {"frontimage.jpg","backimage.jpg","logoimage.jpg"};

            MailGunResponseDto gunRespons = mailGunService.sendMailWithAttachment("admin@mg.mauth.io",to,subject,text,frontImagePath,backImagePath,logoImagePath);
            audit.setStatus(RequestStatus.SUBMITTED);
            spooledMailsRepo.save(new SpooledMail(audit.getId(),true,false,null,gunRespons.getId(),gunRespons.getMessage()));

        } catch (Exception e) {
            audit.setStatus(RequestStatus.FAILED);
            spooledMailsRepo.save(new SpooledMail(audit.getId(),true,true,e.getMessage(),null,null));
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

    private String trimBraces(String seller){
        return seller.split("\\(")[0].trim();
    }
}
