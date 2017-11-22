package io.mauth.fakefood.services;

import io.mauth.fakefood.dto.AuditDto;
import io.mauth.fakefood.repo.AuditRepo;
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
public class AuditServiceImpl implements AuditService {
    @Autowired
    private AuditRepo auditRepo;

    @Override
    public List<AuditDto> getAudit(String androidId) {

        List < AuditDto > auditDtos  = new ArrayList<>();
        auditDtos.add(new AuditDto(1L));
        auditDtos.add(new AuditDto(2L));
        auditDtos.add(new AuditDto(3L));
        auditDtos.add(new AuditDto(4L));
        return auditDtos;

    }

    @Override
    public AuditDto createAudit(AuditDto auditDto) {

        auditRepo.save(auditDto.toAudit());
        return auditDto;
    }

    @Override
    public AuditDto getAudit(Long auditId) {
        return null;
    }
}
