package com.example.demo.presentation.controller;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.domain.service.interfaces.DocumentTypeService;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Tipos de documentos", description = "Gestión de tipos de documentos")
@RestController
@RequestMapping("/documentType")
public class DocumentTypeController {
    private final DocumentTypeService service;

    @Operation(summary = "Crear un tipo de documento")
    @PostMapping
    public ResponseEntity<DocumentType> create(
        @Valid @RequestBody DocumentTypeDto dto) {
        DocumentType saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(summary = "Actualizar un tipo de documento")
    @PutMapping("/{id}")
    public ResponseEntity<DocumentType> update(@PathVariable Integer id,
        @Valid @RequestBody DocumentTypeDto dto) {
        DocumentType updated = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }

    @Operation(summary = "Obtener un tipo de documento por su Id")
    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypePojo> getById(@PathVariable Integer id) {
        DocumentTypePojo found = service.getPojoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(found);
    }

    @Operation(summary = "Eliminar un tipo de documento por su Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Obtener un listado de tipos de documentos")
    @GetMapping("/search")
    public ResponseEntity<List<DocumentTypePojo>> search() {
        List<DocumentTypePojo> list = service.search();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
