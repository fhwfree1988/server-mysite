package com.project.site.Modules.Product.restcontroller;


import com.project.site.Modules.Product.model.dto.ProductDTO;
import com.project.site.Modules.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(){
        return "Hello";
    }

    @GetMapping("/products")
    public Optional<ProductDTO> getProduct(){
        return /*new Optional<ProductDTO>()*/ null;
    }

    @GetMapping("/product/{id}")
    public /*Optional<ProductDTO>*/ProductDTO getProduct(@PathVariable Long id){
        ProductDTO productDTO = productService.get(id);
        return productDTO;
    }

    @GetMapping("/product/name/{productname}")
    public List<ProductDTO> getProductByName(@PathVariable String productname){
        return productService.getByProductName(productname);
    }

    @GetMapping("/product/namecontains/{productname}")
    public List<ProductDTO> getProductByNameContains(@PathVariable String productname){
        return productService.getByProductName_Contains(productname);
    }
}
