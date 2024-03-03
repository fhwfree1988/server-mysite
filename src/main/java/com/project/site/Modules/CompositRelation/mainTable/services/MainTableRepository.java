package com.project.site.Modules.CompositRelation.mainTable.services;

import com.project.site.Modules.CompositRelation.mainTable.CompositionID;
import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;


public interface MainTableRepository extends Repository<MainTableEntity, CompositionID>/* JpaRepository<MainTableEntity, CompositionID> */ {

}
