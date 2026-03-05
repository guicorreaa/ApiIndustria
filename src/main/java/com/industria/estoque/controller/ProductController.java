package com.industria.estoque.controller;

import com.industria.estoque.dto.product.ProductRegisterDTO;
import com.industria.estoque.dto.product.ProductResponseDTO;
import com.industria.estoque.dto.product.ProductUpdateDTO;
import com.industria.estoque.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerProduct(@Valid @RequestBody ProductRegisterDTO dto) {
        productService.registerNewProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable("productId") Long productId, @Valid @RequestBody ProductUpdateDTO dto) {
        productService.updateProduct(productId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-for-price")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsForPrice(){
        return ResponseEntity.ok(productService.getAllProductsForPrice());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<ProductResponseDTO>> getProduct(@PathVariable("productId") Long productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

}
