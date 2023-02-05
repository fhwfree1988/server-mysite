package com.project.site.Modules.CompositRelation.mainTable.services;

import com.project.site.Modules.CompositRelation.mainTable.CompositionID;
import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MainTableRepository extends JpaRepository<MainTableEntity, CompositionID>  {

}
