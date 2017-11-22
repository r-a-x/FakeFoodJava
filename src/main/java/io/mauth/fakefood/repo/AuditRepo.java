package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rahulb on 10/11/17.
 */
public interface AuditRepo extends JpaRepository<Audit,Long>{
    Audit findById(Long id);
}
