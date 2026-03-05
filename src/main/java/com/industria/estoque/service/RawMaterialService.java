package com.industria.estoque.service;

import com.industria.estoque.dto.rawMaterial.RawMaterialRegisterDTO;
import com.industria.estoque.dto.rawMaterial.RawMaterialUpdateDTO;
import com.industria.estoque.exception.ProductInUseException;
import com.industria.estoque.mapper.RawMaterialMapper;
import com.industria.estoque.model.RawMaterial;
import com.industria.estoque.repository.RawMaterialRepository;
import com.industria.estoque.validator.RawMaterialValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RawMaterialService {

    private final RawMaterialValidator rawMaterialValidator;
    private final RawMaterialMapper rawMaterialMapper;
    private final RawMaterialRepository rawMaterialRepository;

    public void registerNewMaterial(RawMaterialRegisterDTO dto) {
        rawMaterialValidator.rawMaterialAlreadyExists(dto.name());
        RawMaterial entity = rawMaterialMapper.DtoToEntityRegister(dto);
        rawMaterialRepository.save(entity);
    }

    public void updateMaterial(Long materialId, RawMaterialUpdateDTO dto) {
        RawMaterial rawMaterial = rawMaterialValidator.rawMaterialExists(materialId);
        rawMaterialValidator.rawMaterialExistsByNameAndIdNot(dto.name(), materialId);

        rawMaterialMapper.DtoToEntityUpdate(dto, rawMaterial);
        rawMaterialRepository.save(rawMaterial);
    }

    public void deleteMaterial(Long materialId) {
        RawMaterial rawMaterial = rawMaterialValidator.rawMaterialExists(materialId);
        rawMaterialValidator.rawMaterialInUse(materialId);

        rawMaterialRepository.delete(rawMaterial);
    }


}
