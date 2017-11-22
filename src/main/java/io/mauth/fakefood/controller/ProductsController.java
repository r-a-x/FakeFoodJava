package io.mauth.fakefood.controller;

import io.mauth.fakefood.dto.ProductDto;
import io.mauth.fakefood.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/companies/{id}/products",method = RequestMethod.GET)
    public List<ProductDto> getProducts(@PathVariable String id){
        return productsService.getProducts(id);
    }

    @RequestMapping(value = "/companies/{id}/products",method = RequestMethod.POST)
    public ProductDto addProducts(@PathVariable String id,@RequestBody ProductDto productDto){
            return productsService.addProduct(id,productDto);
    }

    @RequestMapping(value = "/companies/{id}/products",method = RequestMethod.PUT)
    public ProductDto updateProducts(@PathVariable String id,@RequestBody ProductDto productDto){
        return productsService.updateProduct(id,productDto);
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public List<ProductDto> getProducts(){
        return productsService.getProducts();
    }

}
/*
*   How should I go about using the various things, Should I use database etc ?
*   I need to decide between mongodb and postgres
*   How are you planning to expand, it First by using the whey protein
* */