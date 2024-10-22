package com.project.site.Modules.Product.model.mapper;

import com.project.site.Modules.Product.model.dto.ProductDTO;
import com.project.site.Modules.Product.model.entity.Product;
import com.project.site.base.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.modelmapper.ModelMapper;*/

import java.util.List;
public class ProductMapperTest implements EntityMapper<ProductDTO, Product> {
    /*@Autowired
    private ModelMapper modelMapper;
*/
    @Override
    public Product toEntity(ProductDTO dto) {
      /*  Product product = modelMapper.map(dto, Product.class);
        return product;*/
        return null;
    }

    @Override
    public ProductDTO toDto(Product entity) {
//        ProductDTO productDTO = modelMapper.map(entity, ProductDTO.class);
//        /*productDTO.setSubmissionDate(entity.getSubmissionDate(),
//                userService.getCurrentUser().getPreference().getTimezone());*/
//        return productDTO;
        return null;
    }

    @Override
    public List<Product> toEntity(List<ProductDTO> dtoList) {
        return null;
    }

    @Override
    public List<ProductDTO> toDto(List<Product> entityList) {
        return null;
    }
}
