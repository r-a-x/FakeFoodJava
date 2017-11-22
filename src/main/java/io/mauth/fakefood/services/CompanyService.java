package io.mauth.fakefood.services;

import io.mauth.fakefood.dto.CompanyDto;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
public interface CompanyService {
    CompanyDto addCompany(CompanyDto companyDto);

    CompanyDto getCompany(Long id);

    CompanyDto updateCompany(CompanyDto companyDto);

    List<CompanyDto> getCompanies();
}
