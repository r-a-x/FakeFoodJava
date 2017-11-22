package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.CompanyDto;
import io.mauth.fakefood.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/companies",method = RequestMethod.POST)
    public CompanyDto addCompany(@RequestBody CompanyDto companyDto){
        return companyService.addCompany(companyDto);
    }

    @RequestMapping(value = "/companies",method = RequestMethod.GET)
    public List<CompanyDto> getcompanies(){
        return companyService.getCompanies();
    }

    @RequestMapping(value = "/companies/{id}",method = RequestMethod.GET)
    public CompanyDto getCompany(@PathVariable(value = "id") Long id){
        return companyService.getCompany(id);
    }

    @RequestMapping(value = "/companies/{id}",method = RequestMethod.PUT)
    public CompanyDto updateCompany(@RequestBody CompanyDto companyDto){
        return companyService.updateCompany(companyDto);
    }

}
