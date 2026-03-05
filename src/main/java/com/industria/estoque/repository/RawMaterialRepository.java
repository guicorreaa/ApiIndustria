package com.industria.estoque.repository;

import com.industria.estoque.model.Product;
import com.industria.estoque.model.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

    @Query("SELECT COUNT(pc) > 0 FROM ProductComposition pc WHERE pc.rawMaterial.id = :rawMaterialId")
    boolean isRawMaterialInUse(Long rawMaterialId);

    @Query("""
        SELECT r FROM RawMaterial r
        WHERE (:materialId IS NULL OR r.id = :materialId)
        ORDER BY r.name ASC
    """)
    List<RawMaterial> findRawMaterial(@Param("materialId") Long materialId);

}
