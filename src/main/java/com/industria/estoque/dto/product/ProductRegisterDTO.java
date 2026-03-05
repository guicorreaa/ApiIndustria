package com.industria.estoque.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRegisterDTO(

        @NotBlank(message = "The name field is required.")
        String name,

        @NotNull(message = "The price field is required.")
        BigDecimal price

) {

}
