package com.project.site.Modules.CompositRelation.mainTable.services;

import com.project.site.Modules.CompositRelation.mainTable.MainTableEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@org.springframework.stereotype.Service
public class MainTableService {


    private final MainTableRepository mainTableRepository;
    private final EntityManager entityManager;

    public MainTableService(EntityManager entityManager, MainTableRepository mainTableRepository) {
        this.entityManager = entityManager;
        this.mainTableRepository = mainTableRepository;
    }

    public MainTableEntity saveMainTable(MainTableEntity mainTable){
        return mainTableRepository.save(mainTable);
    }

    @Transactional
    public String crCount(){
        Session session = entityManager.unwrap(Session.class);
        session.isConnected();
        //Transaction trx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MainTableEntity> criteriaQuery = criteriaBuilder.createQuery(MainTableEntity.class);
        Criteria criteria = session.createCriteria(MainTableEntity.class);

        /*criteria = criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.groupProperty("id"))
                        .add(Projections.rowCount()));*/
        criteria = criteria.setProjection(Projections.rowCount());

        List result = criteria.list();
        //trx.commit();
        System.out.println(result.get(0));
        return "";
    }

    @Transactional
    public String crJoin(){
        Session session = entityManager.unwrap(Session.class);
        session.isConnected();
        //Transaction trx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MainTableEntity> criteriaQuery = criteriaBuilder.createQuery(MainTableEntity.class);
        Criteria criteria = session.createCriteria(MainTableEntity.class);


        /*criteria =*/
        /*Criteria subCriteria =*/ criteria.createCriteria("id.modelTable");
        criteria.add(Restrictions.eq("id.modelTable.id",1001L));
        List result = criteria.list();
        //trx.commit();
        System.out.println(result.get(0));
        return "";
    }
}
