package com.sample.mysite.Modules.Product.model.mapper;

import com.sample.mysite.Modules.Product.model.dto.ProductDTO;
import com.sample.mysite.Modules.Product.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
   /* ProductMapper instance =  Mappers.getMapper( ProductMapper.class );*/
    @Mapping(source = "id", target = "id")
    public ProductDTO convertDTO(Product product);
}
