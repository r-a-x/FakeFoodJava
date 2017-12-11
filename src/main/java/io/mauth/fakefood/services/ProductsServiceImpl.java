package io.mauth.fakefood.services;

import io.mauth.fakefood.core.annotation.Loggable;
import io.mauth.fakefood.dto.ProductDto;
import io.mauth.fakefood.model.*;
import io.mauth.fakefood.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */

@Service
@Transactional
@Loggable
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private FlavourRepo flavourRepo;

    @Autowired
    private ProductsSizeMappingRepo productsSizeMappingRepo;

    @Autowired
    private ProductsFlavoursMappingRepo productsFlavoursMappingRepo;

    @Autowired
    private ProductCompanyMappingRepo productCompanyMappingRepo;


    @Override
    public ProductDto addProduct(String id, ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> getProducts(String id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(String id, ProductDto productDto) {
        return null;
    }


//  This will return the company wise products

    @Override
    public List<ProductDto> getProducts() {

        List<ProductDto> productDtos = new ArrayList<>();


        List<Products> productsList = productRepo.findAll();
        for (int i=0;i<productsList.size();i++){

            Products products = productsList.get(i);
//            ProductDto productDto = new ProductDto(products);

            List<ProductsFlavoursMapping> productsFlavoursMappingList = productsFlavoursMappingRepo.findByProductId(products.getId());
            List<String> flavoursList = new ArrayList<>();
            for (int j=0;j<productsFlavoursMappingList.size();j++)
                flavoursList.add(productsFlavoursMappingList.get(j).getFlavour());

//            productDto.setFlavours(flavoursList);

            List<ProductsSizesMapping> productsSizesMappingList = productsSizeMappingRepo.findByProductId(products.getId());
            List<String> sizeList = new ArrayList<>();
            for (int j=0;j<productsSizesMappingList.size();j++)
                sizeList.add(productsSizesMappingList.get(j).getSize());

//            productDto.setSizes(sizeList);

            List<ProductCompanyMapping > productCompanyMappingList = productCompanyMappingRepo.findByProductId(products.getId());

            for( int j=0;j<productCompanyMappingList.size();j++){
                Company company = companyRepo.findById(productCompanyMappingList.get(j).getCompanyId());
                ProductDto productDto = new ProductDto(products);
                productDto.setSizes(sizeList);
                productDto.setFlavours(flavoursList);
                productDto.setCompanyName(company.getName());
                productDto.setImage(productCompanyMappingList.get(j).getImage());
                productDto.setName(productCompanyMappingList.get(j).getName());
                productDtos.add(productDto);
            }

        }

        return productDtos;
    }
}
