package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.ProductsSizesMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface ProductsSizeMappingRepo extends JpaRepository<ProductsSizesMapping,Long> {
    List<ProductsSizesMapping> findAll();

    List<ProductsSizesMapping> findByProductId(Long id);
}
