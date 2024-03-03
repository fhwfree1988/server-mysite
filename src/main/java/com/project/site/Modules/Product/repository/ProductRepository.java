package com.project.site.Modules.Product.repository;

import com.project.site.Modules.Product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends org.springframework.data.repository.Repository<Product, Long>/*JpaRepository<Product, Long>*/  {

    List<Product> findByProductName(String productName);
    List<Product> findByProductNameContains(String productName);


}
