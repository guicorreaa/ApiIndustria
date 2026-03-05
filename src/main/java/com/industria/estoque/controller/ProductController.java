package com.industria.estoque.controller;

import com.industria.estoque.dto.product.ProductRegisterDTO;
import com.industria.estoque.dto.product.ProductUpdateDTO;
import com.industria.estoque.service.ProductionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductionService productionService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProduct(@Valid ProductRegisterDTO dto) {
        productionService.registerNewProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable("productId") Long productId, @Valid ProductUpdateDTO dto) {
        productionService.updateProduct(productId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {

    }

}
