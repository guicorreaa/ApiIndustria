package com.industria.estoque.service;

import com.industria.estoque.dto.production.ProductSuggestionItemDTO;
import com.industria.estoque.dto.production.ProductionSuggestionDTO;
import com.industria.estoque.model.Product;
import com.industria.estoque.model.ProductComposition;
import com.industria.estoque.model.RawMaterial;
import com.industria.estoque.repository.ProductCompositionRepository;
import com.industria.estoque.repository.ProductRepository;
import com.industria.estoque.repository.RawMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductionService {

    private final ProductRepository productRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final ProductCompositionRepository compositionRepository;

    public ProductionSuggestionDTO calculateSuggestion() {
        List<Product> products = productRepository.findAllProductsOrderedByPrice();

        List<ProductComposition> allCompositions = compositionRepository.findAll();
        Map<Long, List<ProductComposition>> compositionsByProduct = allCompositions.stream()
                .collect(Collectors.groupingBy(c -> c.getProduct().getId()));

        Map<Long, BigDecimal> mapStock = rawMaterialRepository.findAll().stream()
                .collect(Collectors.toMap(RawMaterial::getId, RawMaterial::getStockQuantity));

        List<ProductSuggestionItemDTO> suggestions = new ArrayList<>();
        BigDecimal totalRevenue = BigDecimal.ZERO;

        for (Product product : products) {

            List<ProductComposition> compositions = compositionsByProduct.getOrDefault(product.getId(), new ArrayList<>());

            if (compositions.isEmpty()) continue;

            int maxUnits = Integer.MAX_VALUE;

            for (ProductComposition comp : compositions) {
                BigDecimal available = mapStock.getOrDefault(comp.getRawMaterial().getId(), BigDecimal.ZERO);

                int possibleUnitsWithMaterial = available.divide(comp.getRequiredQuantity(), 0, RoundingMode.DOWN).intValue();
                maxUnits = Math.min(maxUnits, possibleUnitsWithMaterial);
            }

            if (maxUnits > 0) {
                for (ProductComposition comp : compositions) {
                    BigDecimal used = comp.getRequiredQuantity().multiply(BigDecimal.valueOf(maxUnits));
                    Long materialId = comp.getRawMaterial().getId();
                    mapStock.put(materialId, mapStock.get(materialId).subtract(used));
                }

                BigDecimal itemValue = product.getPrice().multiply(BigDecimal.valueOf(maxUnits));
                suggestions.add(new ProductSuggestionItemDTO(
                        product.getName(),
                        maxUnits,
                        product.getPrice(),
                        itemValue
                ));
                totalRevenue = totalRevenue.add(itemValue);
            }
        }

        return new ProductionSuggestionDTO(suggestions, totalRevenue);
    }
}