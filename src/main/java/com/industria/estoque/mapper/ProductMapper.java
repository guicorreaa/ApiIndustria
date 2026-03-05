package com.industria.estoque.mapper;

import com.industria.estoque.dto.product.ProductRegisterDTO;
import com.industria.estoque.dto.product.ProductResponseDTO;
import com.industria.estoque.dto.product.ProductUpdateDTO;
import com.industria.estoque.model.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductResponseDTO> entityToDto(List<Product> products);

    Product DtoToEntityRegister (ProductRegisterDTO productRegisterDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product DtoToEntityUpdate (ProductUpdateDTO productUpdateDTO, @MappingTarget Product product);

}
