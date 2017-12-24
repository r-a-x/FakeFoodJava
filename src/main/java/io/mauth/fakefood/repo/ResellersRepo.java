package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.Resellers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rahulb on 11/12/17.
 */
public interface ResellersRepo extends JpaRepository<Resellers,Long>{

    Resellers findByName(String name);
}
