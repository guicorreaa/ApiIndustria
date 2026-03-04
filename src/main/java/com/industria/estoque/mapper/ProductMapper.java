package com.industria.estoque.mapper;

import com.industria.estoque.dto.product.ProductResponseDTO;
import com.industria.estoque.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductResponseDTO> entityToDto(List<Product> products);

}
