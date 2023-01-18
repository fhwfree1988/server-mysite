package com.project.site.Modules.Product.model.mapper;

import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.dto.ProductDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    /* ProductMapper instance =  Mappers.getMapper( ProductMapper.class );*/
    @Mapping(source = "id", target = "id")
    @Named("toProduct")
    Product toProduct(ProductDTO productDTO);

    @Named("toProductDTO")
    public ProductDTO toProductDTO(Product product);


    @IterableMapping(qualifiedByName = "toProduct")
    List<Product> toProduct(List<ProductDTO> productDTOS);

    @IterableMapping(qualifiedByName = "toProductDTO")
    List<ProductDTO> toProductDTO(List<Product> products);
}
