package com.industria.estoque.validator;

import com.industria.estoque.exception.*;
import com.industria.estoque.model.Product;
import com.industria.estoque.model.RawMaterial;
import com.industria.estoque.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RawMaterialValidator {

    private final RawMaterialRepository rawMaterialRepository;

    public void rawMaterialAlreadyExists(String name) {
        boolean existsMaterial = rawMaterialRepository.existsByNameIgnoreCase(name);
        if (existsMaterial) {
            throw new RawMaterialAlreadyExistsException("The raw material already exists within the system!");
        }
    }

    public RawMaterial rawMaterialExists(Long materialId){
        return rawMaterialRepository.findById(materialId).orElseThrow(() -> new RawMaterialNoExistsException("Raw materials don't exist in the system!"));
    }

    public void rawMaterialExistsByNameAndIdNot(String name, Long materialId) {
        boolean rawMaterial = rawMaterialRepository.existsByNameIgnoreCaseAndIdNot(name, materialId);
        if (rawMaterial) {
            throw new RawMaterialAlreadyExistsException("The raw material already exists within the system!");
        }
    }

    public void rawMaterialInUse(Long materialId) {
        boolean rawMaterial = rawMaterialRepository.isRawMaterialInUse(materialId);
        if (rawMaterial) {
            throw new RawMaterialInUseException("The raw material is in use!");
        }
    }

}
