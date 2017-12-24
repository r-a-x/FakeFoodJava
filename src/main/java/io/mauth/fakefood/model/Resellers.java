package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by rahulb on 11/12/17.
 */
@Entity
@DynamicUpdate
@Table(name = "sellers")
public class Resellers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ecom")
    @Enumerated(EnumType.STRING)
    private Ecom ecom;

    @Column(name="url")
    private String url;

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

    public Ecom getEcom() {
        return ecom;
    }

    public void setEcom(Ecom ecom) {
        this.ecom = ecom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
