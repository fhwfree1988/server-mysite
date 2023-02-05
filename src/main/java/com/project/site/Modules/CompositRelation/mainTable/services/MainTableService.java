package com.project.site.Modules.CompositRelation.mainTable.services;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;

@org.springframework.stereotype.Service
public class MainTableService {

    private final MainTableRepository mainTableRepository;
    public MainTableService(MainTableRepository repository) {
        this.mainTableRepository = repository;
    }

    public MainTableEntity saveMainTable(MainTableEntity mainTable){
        return mainTableRepository.save(mainTable);
    }
}
