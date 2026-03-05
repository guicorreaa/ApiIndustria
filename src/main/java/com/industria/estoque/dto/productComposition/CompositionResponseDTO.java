package com.industria.estoque.dto.productComposition;

import java.math.BigDecimal;

public record CompositionResponseDTO(
        Long id,
        Long productId,
        Long rawMaterialId,
        String rawMaterialName,
        BigDecimal requiredQuantity
) {}
