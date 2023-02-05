package com.project.site.Modules.CompositRelation.modelTable.services;

import com.project.site.Modules.CompositRelation.modelTable.ModelTableEntity;
import org.springframework.stereotype.Service;

@Service
public class ModelTableService {

    private final ModelTableReposiroty modelReposiroty;

    public ModelTableService(ModelTableReposiroty modelReposiroty) {
        this.modelReposiroty = modelReposiroty;
    }

    public ModelTableEntity saveModelTable(ModelTableEntity modelTable){
        return modelReposiroty.save(modelTable);
    }
}
