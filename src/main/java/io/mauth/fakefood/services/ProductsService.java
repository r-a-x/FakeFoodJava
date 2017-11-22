package io.mauth.fakefood.services;

import io.mauth.fakefood.dto.ProductDto;

import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
public interface ProductsService {
    ProductDto addProduct(String id, ProductDto productDto);

    List<ProductDto> getProducts(String id);

    ProductDto updateProduct(String id, ProductDto productDto);

    List<ProductDto> getProducts();

}
