package com.project.site.Modules.CompositRelation.secCompTable;

import com.project.site.Modules.CompositRelation.mainTable.CompositionID;
import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import com.project.site.Modules.CompositRelation.modelTable.ModelTableEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

//@Embeddable
public class SecCompositionID implements Serializable {

    //private CompositionID compositionID;
    private MainTableEntity mainTable;

    private ModelTableEntity modelTable;


   /* public CompositionID getCompositionID() {
        return compositionID;
    }

    public void setCompositionID(CompositionID compositionID) {
        this.compositionID = compositionID;
    }*/


    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "fk1",referencedColumnName = "cid"),
                    @JoinColumn(name = "fk2",referencedColumnName = "model_id")
            }
    )
    public MainTableEntity getMainTable() {
        return mainTable;
    }
    public void setMainTable(MainTableEntity mainTable) {
        this.mainTable = mainTable;
    }

    /*@OneToOne*/
    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "model_id")
    public ModelTableEntity getModelTable() {
        return modelTable;
    }

    public void setModelTable(ModelTableEntity modelTable) {
        this.modelTable = modelTable;
    }
}
