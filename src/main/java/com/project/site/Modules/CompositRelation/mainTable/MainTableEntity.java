package com.project.site.Modules.CompositRelation.mainTable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "main_table")
public class MainTableEntity implements Serializable {


    private CompositionID id;
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @EmbeddedId
    public CompositionID getId() {
        return id;
    }

    public void setId(CompositionID id) {
        this.id = id;
    }
}


