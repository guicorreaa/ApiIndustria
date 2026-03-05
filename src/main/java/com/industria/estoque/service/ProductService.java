package com.industria.estoque.service;

import com.industria.estoque.dto.product.ProductRegisterDTO;
import com.industria.estoque.dto.product.ProductResponseDTO;
import com.industria.estoque.dto.product.ProductUpdateDTO;
import com.industria.estoque.mapper.ProductMapper;
import com.industria.estoque.model.Product;
import com.industria.estoque.repository.ProductRepository;
import com.industria.estoque.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductValidator productValidator;

    public List<ProductResponseDTO> getAllProductsForPrice() {
        return productMapper.entityToDto(productRepository.findAllProductsOrderedByPrice());
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productMapper.entityToDto(productRepository.findAll());
    }

    public List<ProductResponseDTO> getProduct(Long productId) {
        return productMapper.entityToDto(productRepository.findProducts(productId));
    }

    public void registerNewProduct(ProductRegisterDTO dto) {
        productValidator.productAlreadyExists(dto.name());
        Product product = productMapper.DtoToEntityRegister(dto);
        productRepository.save(product);
    }

    public void updateProduct(Long productId, ProductUpdateDTO dto) {
        Product product = productValidator.productExists(productId);
        productValidator.productExistsByNameAndIdNot(dto.name(), productId);

        productMapper.DtoToEntityUpdate(dto, product);
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        Product product = productValidator.productExists(productId);
        productValidator.productInUse(productId);

        productRepository.delete(product);
    }
}
