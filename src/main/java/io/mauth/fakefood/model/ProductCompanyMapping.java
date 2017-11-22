package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by rahulb on 12/11/17.
 */
@Entity
@Table(name ="product_company_mapping")
@DynamicUpdate
public class ProductCompanyMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "image")
    private String image;

    public ProductCompanyMapping() {
    }

    public ProductCompanyMapping(Long productId, Long companyId, String image) {
        this.productId = productId;
        this.companyId = companyId;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
