package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.AuditDto;
import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import io.mauth.fakefood.model.Company;
import io.mauth.fakefood.repo.AuditRepo;
import io.mauth.fakefood.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@Service
@Transactional
@Loggable
public class AuditServiceImpl implements AuditService {
    @Autowired
    private AuditRepo auditRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private SpooledMailService spooledMailService;

    @Override
    public List<AuditDto> getAudit(String androidId) {

        List < Audit > audits =  auditRepo.findByAndroidId(androidId);

        List<AuditDto > auditDtos = new ArrayList<>();

        for (int i=0;i<audits.size();i++){
            Audit audit = audits.get(i);
            AuditDto auditDto = audit.toAuditDto();
            Company company = companyRepo.findById(audit.getCompanyId());
            auditDto.setCompany(company.getName());
            auditDtos.add( audit.toAuditDto() );
        }

        return auditDtos;

    }

    @Override
    public AuditDto createAudit(AuditDto auditDto) {

        Audit audit = auditDto.toAudit();
        audit.setStatus(RequestStatus.PENDING);
        auditRepo.save(audit);



//        spooledMailService.sendUnsentMails();

        return auditDto;
    }

    @Override
    public AuditDto getAudit(Long auditId) {
        return null;
    }
}
