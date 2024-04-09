package com.project.site.Modules.CompositRelation.modelTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Document
@Table(name = "model")
public class ModelTableEntity implements Serializable {

    @Id
    @Column(name = "model_id")
    private Long id;
    private String name;

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


}
