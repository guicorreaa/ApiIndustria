package com.industria.estoque.validator;

import com.industria.estoque.exception.ProductCompositionNoExistsException;
import com.industria.estoque.model.ProductComposition;
import com.industria.estoque.repository.ProductCompositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCompositionValidator {

    private final ProductCompositionRepository productCompositionRepository;

    public ProductComposition productCompositionExists(Long compositionId){
        return productCompositionRepository.findById(compositionId).orElseThrow(() -> new ProductCompositionNoExistsException("Product composition does not exist in the system!"));
    }

}
