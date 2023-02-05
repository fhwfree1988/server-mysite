package com.project.site.Modules.CompositRelation.secTable.services;

import com.project.site.Modules.CompositRelation.secTable.SecTableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class SecTableService {

    private final SecTableRepository secTableRepository;

    public SecTableService(SecTableRepository secTableRepository) {
        this.secTableRepository = secTableRepository;
    }

    public SecTableEntity saveSecTable(SecTableEntity secTableEntity){
        return secTableRepository.save(secTableEntity);
    }

   /* @Autowired
    private EntityManager entityManager;

    public SecTableEntity saveSecTable(SecTableEntity secTableEntity){
        entityManager.persist(secTableEntity);
        entityManager.flush();
        return secTableEntity;
    }*/
}
