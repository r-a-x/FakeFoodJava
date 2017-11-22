package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface ProductRepo extends JpaRepository<Products,Long>{
    List<Products> findAll();
    Products findById(Long id);
}
