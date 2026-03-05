package com.industria.estoque.repository;

import com.industria.estoque.model.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(String name, Long id);

    @Query("SELECT COUNT(pc) > 0 FROM ProductComposition pc WHERE pc.rawMaterial.id = :rawMaterialId")
    boolean isRawMaterialInUse(Long rawMaterialId);
}
