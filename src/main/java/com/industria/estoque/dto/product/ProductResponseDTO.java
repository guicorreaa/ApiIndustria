package com.industria.estoque.dto.product;

import java.math.BigDecimal;

public record ProductResponseDTO (
                Long id,
                String name,
                BigDecimal price
        ) {
}