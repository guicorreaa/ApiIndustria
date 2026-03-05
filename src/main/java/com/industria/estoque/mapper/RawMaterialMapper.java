package com.industria.estoque.mapper;

import com.industria.estoque.dto.rawMaterial.RawMaterialRegisterDTO;
import com.industria.estoque.dto.rawMaterial.RawMaterialResponseDTO;
import com.industria.estoque.dto.rawMaterial.RawMaterialUpdateDTO;
import com.industria.estoque.model.RawMaterial;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RawMaterialMapper {

    RawMaterial DtoToEntityRegister(RawMaterialRegisterDTO rawMaterialRegisterDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RawMaterial DtoToEntityUpdate(RawMaterialUpdateDTO rawMaterialUpdateDTO, @MappingTarget RawMaterial rawMaterial);

    List<RawMaterialResponseDTO> entityToDto(List<RawMaterial> rawMaterials);

}
