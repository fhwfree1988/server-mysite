package com.project.site.Modules.Product.service;


import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.mapper.ProductMapper;
import com.project.site.Modules.Product.repository.ProductRepository;
import com.project.site.Modules.Product.model.dto.ProductDTO;
import com.project.site.base.exception.BaseRemoteExceptionConstants;
import com.project.site.base.exception.BaseRemoteExceptionRegistry;
import com.project.site.base.mapper.TokenMapper;
import com.project.site.base.ratelimit.RateLimiterManager;
import com.project.site.base.ratelimit.TokenListService.TokenEntity;
import com.project.site.base.ratelimit.TokenListService.TokenListServiceImpleHashMap;
import io.github.bucket4j.Bucket;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final int TOKEN_CONSUME = 1;

    private final EntityManager entityManager;
    private final ProductRepository productRepository;
    private final /*ProductMapperTest*/ ProductMapper productMapper;
    private final RateLimiterManager rateLimiterManager;
    private final /*TokenListService*/TokenListServiceImpleHashMap tokenListService;
    private final TokenMapper tokenMapper;

    public ProductService(EntityManager entityManager, ProductRepository productRepository, ProductMapper productMapper, RateLimiterManager rateLimiterManager, TokenListServiceImpleHashMap tokenListService, TokenMapper tokenMapper) {
        this.entityManager = entityManager;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.rateLimiterManager = rateLimiterManager;
        this.tokenMapper = tokenMapper;
        this.tokenListService = tokenListService;
    }

    public ProductDTO get(final Long productId){
        TokenEntity tokenEntity = tokenListService.getToken("/product/{id}");
        Bucket bucket = rateLimiterManager.getUserServiceBucket(/*getCurrentUserId()*/"1", tokenMapper.convertTokenModel(tokenEntity));
        //for mongo
        /*if (bucket.tryConsume(TOKEN_CONSUME)) {
            return this.productRepository.findById(productId).map(product -> productMapper.toProductDTO(product))
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }*/
        throw BaseRemoteExceptionRegistry.create(BaseRemoteExceptionConstants.STATUS__TOO_MANY_REQUESTS);

    }
    public List<ProductDTO> getByProductName(final String productName){
        //https://stackoverflow.com/questions/40035102/how-to-convert-a-list-with-properties-to-a-another-list-the-java-8-way
        return this.productRepository.findByProductName(productName)
                .stream().map(product -> productMapper.toProductDTO(product)).collect(Collectors.toList());
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public List<ProductDTO> getByProductName_Contains(final String productName){
        //https://www.baeldung.com/spring-jpa-like-queries
        return this.productRepository.findByProductNameContains(productName)
                .stream().map(product -> productMapper.toProductDTO(product)).collect(Collectors.toList());
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
        //for mongo
        /*if (productDTO.getUser() != null && (product.getUser() == null || !product.getUser().getId().equals(productDTO.getUser().getId()))) {
            final User user = userRepository.findById(productDTO.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            product.setUser(user);
        }*/
        return product;
    }

}
