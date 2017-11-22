package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.ProductsFlavoursMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface ProductsFlavoursMappingRepo extends JpaRepository<ProductsFlavoursMapping,Long> {
    List<ProductsFlavoursMapping> findAll();

    List<ProductsFlavoursMapping> findByProductId(Long id);
}
