package com.industria.estoque.service;

import com.industria.estoque.dto.product.ProductResponseDTO;
import com.industria.estoque.dto.product.ProductionSuggestionDTO;
import com.industria.estoque.mapper.ProductMapper;
import com.industria.estoque.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponseDTO> getAllProductsForPrice() {
        return productMapper.entityToDto(productRepository.findAllProductsOrderedByPrice());
    }

    public List<ProductionSuggestionDTO>
}
