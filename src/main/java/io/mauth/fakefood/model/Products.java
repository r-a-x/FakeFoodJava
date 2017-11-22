package io.mauth.fakefood.model;

import io.mauth.fakefood.enums.FoodType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by rahulb on 4/11/17.
 */
@Entity
@DynamicUpdate
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;


//    This is not being used

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "type")
    private String type;

    @Column(name="description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name ="food_type")
    private FoodType foodType;

    @Column(name = "images")
    private String image;

    @Column(name ="flavours")
    private String flavours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlavours() {
        return flavours;
    }

    public void setFlavours(String flavours) {
        this.flavours = flavours;
    }

    //    1 NF, there should be repeated rows
//    2 NF, there should not be dependency of some column on the subset of candidate key

}
