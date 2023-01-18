package com.project.site.base.mapper;

import com.project.site.Modules.Product.model.dto.ProductDTO;
import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.base.model.TokenModel;
import com.project.site.base.ratelimit.TokenListService.TokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//https://stackoverflow.com/questions/73947873/mapping-to-dto-bidirectional-entities-in-springboot-with-mapstruct

@Mapper(componentModel = "spring")
public interface TokenMapper {
    /* TokenMapper instance =  Mappers.getMapper( TokenMapper.class );*/


    /*@Mapping(source = "serviceName", target = "serviceName")
    @Mapping(source = "token", target = "tokenValue")
    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "callServiceLimit",  ignore = true)
    @Mapping(target = "consumeBucketTimeUnit",  ignore = true)
    @Mapping(target = "consumeBucketDuration",  ignore = true)
    @Mapping(target = "isActive",  ignore = true)*/
    public TokenModel convertTokenModel(TokenEntity tokenEntity);
}

