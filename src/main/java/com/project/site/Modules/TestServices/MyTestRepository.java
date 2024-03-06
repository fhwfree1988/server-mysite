package com.project.site.Modules.TestServices;

import com.project.site.Modules.Product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mytestrepository")
public interface MyTestRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "Select  p.id ,p.product_name as productName from product as p where p.product_name like %:#{#product.productName}% ORDER BY productName")
    List<MyProductI> getProductBy(@Param("product") Product product);
}
