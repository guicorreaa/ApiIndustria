package com.industria.estoque.dto.rawMaterial;

import java.math.BigDecimal;

public record RawMaterialResponseDTO(

        Long id,
        String name,
        BigDecimal stockQuantity

) {
}