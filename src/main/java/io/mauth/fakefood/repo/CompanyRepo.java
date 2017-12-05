package io.mauth.fakefood.repo;

import io.mauth.fakefood.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rahulb on 12/11/17.
 */
public interface CompanyRepo extends JpaRepository<Company,Long> {
    List<Company> findAll();


     Company findById(Long companyId) ;

    Company findByEmail(String companyMail);

}
