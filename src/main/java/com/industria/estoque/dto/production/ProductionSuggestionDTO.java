package com.industria.estoque.dto.production;

import java.math.BigDecimal;
import java.util.List;

public record ProductionSuggestionDTO(
        List<ProductSuggestionItemDTO> suggestions,
        BigDecimal totalEstimatedRevenue
) {
}
