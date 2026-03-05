package com.industria.estoque.dto.productComposition;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CompositionItemUpdateDTO(

        @Positive
        @NotNull(message = "The requiredQuantity field is required!")
        BigDecimal requiredQuantity

) {
}
