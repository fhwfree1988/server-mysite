package com.project.site.Modules.CompositRelation.mainTable;

import com.project.site.Modules.CompositRelation.modelTable.ModelTableEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class CompositionID implements Serializable {

    private Long id1;

    private ModelTableEntity modelTable;


    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }


    @OneToOne
    @JoinColumn(name = "model_id",referencedColumnName = "model_id")
    public ModelTableEntity getModelTable() {
        return modelTable;
    }

    public void setModelTable(ModelTableEntity modelTable) {
        this.modelTable = modelTable;
    }
}
