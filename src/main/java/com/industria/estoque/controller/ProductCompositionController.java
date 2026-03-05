package com.industria.estoque.controller;

import com.industria.estoque.dto.productComposition.CompositionItemRegisterDTO;
import com.industria.estoque.dto.productComposition.CompositionItemUpdateDTO;
import com.industria.estoque.dto.productComposition.CompositionResponseDTO;
import com.industria.estoque.service.ProductCompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("composition")
@RequiredArgsConstructor
public class ProductCompositionController {

    private final ProductCompositionService productCompositionService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProductComposition(@RequestBody CompositionItemRegisterDTO dto) {
        productCompositionService.registerComposition(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{compositionId}")
    public ResponseEntity<Void> updateProductComposition(@PathVariable("compositionId") Long compositionId, @RequestBody CompositionItemUpdateDTO dto) {
        productCompositionService.updateComposition(compositionId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{compositionId}")
    public ResponseEntity<Void> deleteProductComposition(@PathVariable("compositionId") Long compositionId) {
        productCompositionService.deleteComposition(compositionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CompositionResponseDTO>> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productCompositionService.getByProduct(productId));
    }

}
