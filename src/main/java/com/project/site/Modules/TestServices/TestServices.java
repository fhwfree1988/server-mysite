package com.project.site.Modules.TestServices;

import com.project.site.Modules.Product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestServices {

    private final EntityManager entityManager;

    public TestServices(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<MyProductDto> NativeQuery(){
        List<MyProductDto> myProductDto = entityManager.createNativeQuery("select id,product_namefrom product", MyProductDto.class).getResultList();
        return myProductDto;
    }

    public List<Product> myCriteraProduct(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);


        Predicate predicateProductName = cb.equal(rootEntry.get("productName"), "pro");
        Predicate predicateProductName_notNull = cb.isNotNull((rootEntry.get("productName")));

        Predicate predicates = cb.and(predicateProductName, predicateProductName_notNull);

        CriteriaQuery<Product> all = cq.select(rootEntry).where(predicates).orderBy(cb.desc(
                cb.function(
                        "substr", String.class,
                        rootEntry.get("productName"),
                        cb.literal("4"),
                        cb.literal("2")
                )
        ));

        TypedQuery<Product> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public List<Long> getProduct(){

        String hqlQuery = "select MAX(pc.Cost), p.productName.id, p.isActive,pc.Cost  from Product p inner join ProductCost pc on (p.id = pc.product.id) group by  (p.id,p.productName) having substr(p.n, 3, 2) = '17'";
        List<Object[]> query = entityManager.createQuery(hqlQuery).getResultList();

        List<Long> productIds = query.stream().map((arraysValue) -> ((Long)(arraysValue)[1])).collect(Collectors.toList());

        return productIds;
    }
}
