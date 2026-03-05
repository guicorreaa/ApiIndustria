package com.industria.estoque.controller;

import com.industria.estoque.dto.production.ProductionSuggestionDTO;
import com.industria.estoque.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("production")
@RequiredArgsConstructor
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping("/suggestion")
    public ResponseEntity<ProductionSuggestionDTO> getProductionSuggestion() {
        ProductionSuggestionDTO suggestion = productionService.calculateSuggestion();
        return ResponseEntity.ok(suggestion);
    }

}
