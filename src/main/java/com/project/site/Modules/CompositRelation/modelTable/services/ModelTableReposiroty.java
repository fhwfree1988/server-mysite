package com.project.site.Modules.CompositRelation.modelTable.services;


import com.project.site.Modules.CompositRelation.modelTable.ModelTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelTableReposiroty extends org.springframework.data.repository.Repository<ModelTableEntity,Long>/* JpaRepository<ModelTableEntity,Long>*/ {
}
