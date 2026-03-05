package com.industria.estoque.dto.rawMaterial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RawMaterialRegisterDTO(

        @NotBlank(message = "The name field is required!")
        String name,

        @NotNull(message = "The stockQuantity field is required!")
        BigDecimal stockQuantity


) {
}