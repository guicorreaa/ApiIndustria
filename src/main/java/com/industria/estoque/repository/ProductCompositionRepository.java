package com.industria.estoque.repository;

import com.industria.estoque.model.ProductComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCompositionRepository extends JpaRepository<ProductComposition, Long> {

    List<ProductComposition> findByProductId(Long productId);
}
