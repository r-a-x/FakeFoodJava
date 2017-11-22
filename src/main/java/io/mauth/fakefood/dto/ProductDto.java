package io.mauth.fakefood.dto;

import io.mauth.fakefood.enums.Currency;
import io.mauth.fakefood.enums.FoodType;
import io.mauth.fakefood.model.Products;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rahulb on 4/11/17.
 */
public class ProductDto implements Serializable {

    private String name;
    private List<String> flavours;
    private List<String> sizes;
    private String product;
    private Double price;
    private Currency currency;
    private String companyName;
    private FoodType foodType;
    private String description;
    private String image;

    public ProductDto() {
    }

    public ProductDto(String name, List<String> flavours, List<String> sizes, String product, Double price, Currency currency) {
        this.name = name;
        this.flavours = flavours;
        this.sizes = sizes;
        this.product = product;
        this.price = price;
        this.currency = currency;
    }

    public ProductDto(Products products) {
        this.name =  products.getName();
        this.image = products.getImage();
        this.description = products.getDescription();
        this.foodType = products.getFoodType();
        this.product = products.getType();
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;

    }

    public List<String> getFlavours() {
        return flavours;
    }

    public ProductDto setFlavours(List<String> flavours) {
        this.flavours = flavours;
        return this;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public ProductDto setSizes(List<String> sizes) {
        this.sizes = sizes;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public ProductDto setProduct(String product) {
        this.product = product;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDto setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public ProductDto setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ProductDto setImage(String image) {
        this.image = image;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ProductDto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public ProductDto setFoodType(FoodType foodType) {
        this.foodType = foodType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
