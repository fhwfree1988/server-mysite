package com.sample.mysite.Modules.Product.repository;


import com.sample.mysite.Modules.Product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);
    List<Product> findByProductNameContains(String productName);


}
