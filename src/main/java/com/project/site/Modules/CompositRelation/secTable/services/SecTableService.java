package com.project.site.Modules.CompositRelation.secTable.services;

import com.project.site.Modules.CompositRelation.secTable.SecTableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SecTableService {

    //JAP repository can not find relation
    private final EntityManager entityManager;

    public SecTableEntity saveSecTable(SecTableEntity secTableEntity){
        /*Session session = entityManager.unwrap(Session.class);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();*/
        entityManager.persist(secTableEntity);
        entityManager.flush();
       /* tx.commit();*/
        return secTableEntity;
    }
}
