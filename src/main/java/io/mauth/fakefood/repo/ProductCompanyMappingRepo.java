package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.ProductCompanyMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface ProductCompanyMappingRepo extends JpaRepository<ProductCompanyMapping,Long> {
    List<ProductCompanyMapping> findByCompanyId(Long id);

    List<ProductCompanyMapping> findByProductId(Long id);

}
