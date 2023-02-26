package com.project.site.Modules.CompositRelation.secCompTable;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sec_table_comp")
public class SecCompTableEntity implements Serializable {


    private SecCompositionID secCompositionID;

    @EmbeddedId
    public SecCompositionID getSecCompositionID() {
        return secCompositionID;
    }

    public void setSecCompositionID(SecCompositionID secCompositionID) {
        this.secCompositionID = secCompositionID;
    }
}