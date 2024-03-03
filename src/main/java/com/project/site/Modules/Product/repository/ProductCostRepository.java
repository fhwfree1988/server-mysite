package com.project.site.Modules.Product.repository;

import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.entity.ProductCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductCostRepository extends org.springframework.data.repository.Repository<ProductCost, Long>/*JpaRepository<ProductCost, Long>*/ {

}
