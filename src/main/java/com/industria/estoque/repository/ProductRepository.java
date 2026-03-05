package com.industria.estoque.repository;

import com.industria.estoque.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p FROM Product p ORDER BY p.price DESC
            """)
    List<Product> findAllProductsOrderedByPrice();

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

    @Query("SELECT COUNT(pc) > 0 FROM ProductComposition pc WHERE pc.product.id = :productId")
    boolean isProductInUse(Long productId);

    @Query("""
        SELECT p FROM Product p
        WHERE (:productId IS NULL OR p.id = :productId)
        ORDER BY p.name ASC
    """)
    List<Product> findProducts(@Param("productId") Long productId);

}
