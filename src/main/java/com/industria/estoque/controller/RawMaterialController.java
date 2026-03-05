package com.industria.estoque.controller;

import com.industria.estoque.dto.rawMaterial.RawMaterialRegisterDTO;
import com.industria.estoque.dto.rawMaterial.RawMaterialResponseDTO;
import com.industria.estoque.dto.rawMaterial.RawMaterialUpdateDTO;
import com.industria.estoque.service.RawMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rawMaterial")
@RequiredArgsConstructor
public class RawMaterialController {

    private final RawMaterialService rawMaterialService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerRawMaterial(@RequestBody RawMaterialRegisterDTO dto){
        rawMaterialService.registerNewMaterial(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{materialId}")
    public ResponseEntity<Void> updateRawMaterial(@PathVariable("materialId") Long materialId, @RequestBody RawMaterialUpdateDTO dto) {
        rawMaterialService.updateMaterial(materialId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{materialId}")
    public ResponseEntity<Void> deleteRawMaterial(@PathVariable("materialId") Long materialId){
        rawMaterialService.deleteMaterial(materialId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RawMaterialResponseDTO>> getAllMaterials() {
        return ResponseEntity.ok(rawMaterialService.getAllMaterials());
    }

    @GetMapping("/get-material/{materialId}")
    public ResponseEntity<List<RawMaterialResponseDTO>> getMaterial(@PathVariable("materialId") Long materialId) {
        return ResponseEntity.ok(rawMaterialService.getMaterial(materialId));
    }

}
