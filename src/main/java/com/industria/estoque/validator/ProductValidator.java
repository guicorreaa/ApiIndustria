package com.industria.estoque.validator;

import com.industria.estoque.exception.ProductAlreadyExistsException;
import com.industria.estoque.exception.ProductInUseException;
import com.industria.estoque.exception.ProductNoExistsException;
import com.industria.estoque.model.Product;
import com.industria.estoque.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductValidator {

    private final ProductRepository productRepository;

    public void productAlreadyExists(String name) {
        boolean existsProduct = productRepository.existsByNameIgnoreCase(name);
        if (existsProduct) {
            throw new ProductAlreadyExistsException("The product already exists within the system!");
        }
    }

    public Product productExists(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNoExistsException("The product was not found!"));
    }

    public void productExistsByNameAndIdNot(String name, Long id) {
        boolean product = productRepository.existsByNameIgnoreCaseAndIdNot(name, id);
        if (product) {
            throw new ProductAlreadyExistsException("The product already exists within the system!");
        }
    }

    public void productInUse(Long productId) {
        boolean product = productRepository.isProductInUse(productId);
        if (product) {
            throw new ProductInUseException("The product is in use!");
        }
    }

}