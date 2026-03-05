package com.industria.estoque.mapper;

import com.industria.estoque.dto.productComposition.CompositionItemRegisterDTO;
import com.industria.estoque.dto.productComposition.CompositionItemUpdateDTO;
import com.industria.estoque.model.ProductComposition;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductCompositionMapper {

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "rawMaterial", ignore = true)
    ProductComposition DtoToEntityRegister(CompositionItemRegisterDTO compositionItemRegisterDTO);

    @Mapping(target = "product", ignore = true)
    @Mapping(target = "rawMaterial", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProductComposition DtoToEntityUpdate(CompositionItemUpdateDTO compositionItemUpdateDTO, @MappingTarget ProductComposition productComposition);
}
