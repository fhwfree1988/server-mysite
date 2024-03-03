package com.project.site.Modules.CompositRelation.secCompTable;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Entity
@Document
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