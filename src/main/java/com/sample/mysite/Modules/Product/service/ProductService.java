package com.project.site.Modules.Product.service;


import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.mapper.ProductMapper;
import com.project.site.Modules.Product.repository.ProductRepository;
import com.project.site.Modules.Product.model.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final /*ProductMapperTest*/ ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO get(final Long productId){
        return this.productRepository.findById(productId).map(product -> productMapper.convertDTO(product))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public List<ProductDTO> getByProductName(final String productName){
        //https://stackoverflow.com/questions/40035102/how-to-convert-a-list-with-properties-to-a-another-list-the-java-8-way
        return this.productRepository.findByProductName(productName)
                .stream().map(product -> productMapper.convertDTO(product)).collect(Collectors.toList());
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public List<ProductDTO> getByProductName_Contains(final String productName){
        //https://www.baeldung.com/spring-jpa-like-queries
        return this.productRepository.findByProductNameContains(productName)
                .stream().map(product -> productMapper.convertDTO(product)).collect(Collectors.toList());
        //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    private ProductDTO mapToDTO(final Product product,
//                                final ProductDTO productDTO) {
//        /*productDTO.setId(product.getId());
//        productDTO.setProductName(product.getProductName());
//        productDTO.setProductNo(product.getProductNo());
//        //productDTO.setUser(product.getUser() == null ? null : product.getUser());
//        return productDTO;*/
//        return productMapper.toDto(product);
//
//    }

    private Product mapToEntity(final ProductDTO productDTO,
                                final Product product) {
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setProductNo(productDTO.getProductNo());
        /*if (productDTO.getUser() != null && (product.getUser() == null || !product.getUser().getId().equals(productDTO.getUser().getId()))) {
            final User user = userRepository.findById(productDTO.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            product.setUser(user);
        }*/
        return product;
    }
}
