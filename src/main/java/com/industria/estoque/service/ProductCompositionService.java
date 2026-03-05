package com.industria.estoque.service;

import com.industria.estoque.dto.productComposition.CompositionItemRegisterDTO;
import com.industria.estoque.dto.productComposition.CompositionItemUpdateDTO;
import com.industria.estoque.mapper.ProductCompositionMapper;
import com.industria.estoque.model.Product;
import com.industria.estoque.model.ProductComposition;
import com.industria.estoque.model.RawMaterial;
import com.industria.estoque.repository.ProductCompositionRepository;
import com.industria.estoque.validator.ProductCompositionValidator;
import com.industria.estoque.validator.ProductValidator;
import com.industria.estoque.validator.RawMaterialValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCompositionService {

    private final ProductValidator productValidator;
    private final RawMaterialValidator rawMaterialValidator;
    private final ProductCompositionValidator productCompositionValidator;

    private final ProductCompositionMapper productCompositionMapper;
    private final ProductCompositionRepository productCompositionRepository;

    public void registerComposition(CompositionItemRegisterDTO dto) {
        Product product = productValidator.productExists(dto.productId());
        RawMaterial rawMaterial = rawMaterialValidator.rawMaterialExists(dto.rawMaterialId());

        ProductComposition entity = productCompositionMapper.DtoToEntityRegister(dto);
        entity.setProduct(product);
        entity.setRawMaterial(rawMaterial);

        productCompositionRepository.save(entity);
    }

    public void updateComposition(Long compositionId, CompositionItemUpdateDTO dto) {
        ProductComposition composition = productCompositionValidator.productCompositionExists(compositionId);

        productCompositionMapper.DtoToEntityUpdate(dto, composition);
        productCompositionRepository.save(composition);

    }

    public void deleteComposition(Long compositionId) {
        ProductComposition composition = productCompositionValidator.productCompositionExists(compositionId);
        productCompositionRepository.delete(composition);
    }

}
