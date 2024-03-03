package com.project.site.Modules.CompositRelation.secTable;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Entity
@Document
@Table(name = "sec_table")
public class SecTableEntity implements Serializable {


    private MainTableEntity mainTable;


    @ManyToOne()
    @JoinColumns(
            {
                    @JoinColumn(name = "fk1",referencedColumnName = "cid"),
                    @JoinColumn(name = "fk2",referencedColumnName = "model_id")
            }
    )
    @Id
    public MainTableEntity getMainTable() {
        return mainTable;
    }

    public void setMainTable(MainTableEntity mainTable) {
        this.mainTable = mainTable;
    }
}
