package com.industria.estoque.repository;

import com.industria.estoque.model.ProductComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCompositionRepository extends JpaRepository<ProductComposition, Long> {

    List<ProductComposition> findByProductId(Long productId);

    // Opcional: Busca uma associação específica para evitar duplicados manualmente
    Optional<ProductComposition> findByProductIdAndRawMaterialId(Long productId, Long rawMaterialId);
}
