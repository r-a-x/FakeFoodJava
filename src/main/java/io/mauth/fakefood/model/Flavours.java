package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by rahulb on 4/11/17.
 */

@Entity
@Table(name ="flavours")
@DynamicUpdate
public class Flavours  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name ="flavour")
    private String flavour;

}
