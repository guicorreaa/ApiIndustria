package com.industria.estoque.dto.productComposition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CompositionItemRegisterDTO(

        @NotNull(message = "The productId field is required!")
        Long productId,

        @NotNull(message = "The rawMaterialId field is required!")
        Long rawMaterialId,

        @Positive
        @NotNull(message = "The requiredQuantity field is required!")
        BigDecimal requiredQuantity

) {
}
