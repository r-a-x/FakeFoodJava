package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.CompanyDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@Service
@Transactional
@Loggable
public class CompanyServiceImpl implements CompanyService {
    @Override
    public CompanyDto addCompany(CompanyDto companyDto) {
        return null;
    }

    @Override
    public CompanyDto getCompany(Long id) {
        return null;
    }

    @Override
    public CompanyDto updateCompany(CompanyDto companyDto) {
        return null;
    }

    @Override
    public List<CompanyDto> getCompanies() {
        return null;
    }
}
