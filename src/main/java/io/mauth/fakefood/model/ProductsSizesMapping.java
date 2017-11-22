package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rahulb on 4/11/17.
 */
@Entity
@DynamicUpdate
@Table(name = "product_sizes_mapping")
public class ProductsSizesMapping {

    @Id
    private Long id;

    @Column(name="size")
    private String size;

    @Column(name="product_id")
    private Long productId;

    @Column(name = "unit")
    private String unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
