package com.project.site.Modules.CompositRelation.secTable.services;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import com.project.site.Modules.CompositRelation.secTable.SecTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecTableRepository extends CrudRepository<SecTableEntity, Long/*MainTableEntity*/> {
}
