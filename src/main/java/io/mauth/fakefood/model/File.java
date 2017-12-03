package io.mauth.fakefood.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rahulb on 3/12/17.
 */


@Entity
@DynamicUpdate
@Table(name = "file_request")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id; // It will be stored in the local db, just tells the request made by the user

    @Column(name = "name")
    private String name;

    @Column(name ="path")
    private String path;

    @Column(name = "created_on")
    private Date createdOn;

    public File() {
    }
    {
        this.createdOn = new Date();
    }
    public File(String name, String path) {
        this.name = name;
        this.path = path;
    }
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
