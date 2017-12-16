package io.mauth.fakefood.repo;

import io.mauth.fakefood.enums.RequestStatus;
import io.mauth.fakefood.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 10/11/17.
 */
public interface AuditRepo extends JpaRepository<Audit,Long>{

    Audit findById(Long id);

    List<Audit> findByAndroidId(String androidId);

    List<Audit> findByStatus(RequestStatus status);

    Audit findByAndroidIdAndCompanyId(String androidId, Long companyId);

    Audit findByAndroidIdAndCompanyIdAndId(String androidId, Long companyId, Long id);
}
