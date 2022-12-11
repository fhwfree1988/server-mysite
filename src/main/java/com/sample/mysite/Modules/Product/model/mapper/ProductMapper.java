package com.project.site.Modules.Product.model.mapper;

import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.Modules.Product.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
   /* ProductMapper instance =  Mappers.getMapper( ProductMapper.class );*/
    @Mapping(source = "id", target = "id")
    public ProductDTO convertDTO(Product product);
}
