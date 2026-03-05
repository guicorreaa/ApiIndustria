package com.industria.estoque.mapper;

import com.industria.estoque.dto.productComposition.CompositionItemRegisterDTO;
import com.industria.estoque.dto.productComposition.CompositionItemUpdateDTO;
import com.industria.estoque.dto.productComposition.CompositionResponseDTO;
import com.industria.estoque.model.ProductComposition;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCompositionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "rawMaterial", ignore = true)
    ProductComposition DtoToEntityRegister(CompositionItemRegisterDTO compositionItemRegisterDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "rawMaterial", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductComposition DtoToEntityUpdate(CompositionItemUpdateDTO compositionItemUpdateDTO, @MappingTarget ProductComposition productComposition);

    @Mapping( target = "productId", source = "product.id")
    @Mapping(target = "rawMaterialId", source = "rawMaterial.id")
    @Mapping(target = "rawMaterialName", source = "rawMaterial.name")
    @Mapping(target = "requiredQuantity", source = "requiredQuantity" )
    CompositionResponseDTO entityToDto(ProductComposition productComposition);

    List<CompositionResponseDTO> entityToDto(List<ProductComposition> productCompositions);
}
