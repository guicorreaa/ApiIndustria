package com.industria.estoque.dto.production;

import java.math.BigDecimal;

public record ProductSuggestionItemDTO(
        String productName,
        Integer quantityPossible,
        BigDecimal unitPrice,
        BigDecimal totalValue
) {
}
