package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.AuditDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@Service
@Transactional
@Loggable
public interface AuditService {
    List<AuditDto> getAudit(String androidId);

    AuditDto createAudit(AuditDto auditDto);

    AuditDto getAudit(Long auditId);

}
