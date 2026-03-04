package com.industria.estoque.dto.product;

import java.math.BigDecimal;

public record ProductionSuggestionDTO(
        String name,
        BigDecimal price,
        Integer quantitySuggested,
        BigDecimal totalValue
) {
}
