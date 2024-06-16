package com.example.demo.presentation.controller;

import com.example.demo.domain.service.interfaces.DocumentTypeService;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/documentType")
@RestController
public class DocumentTypeController {
    private final DocumentTypeService documentTypeService;

    @PostMapping()
    public ResponseEntity<DocumentTypePojo> createDocumentType( @RequestBody DocumentTypeDto documentTypeDto) {
        return ResponseEntity.ok(documentTypeService.createDocumentType(documentTypeDto));
    }

    @GetMapping()
    public ResponseEntity<List <DocumentTypePojo>> getAll() {
        return ResponseEntity.ok(documentTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypePojo> getDocumentTypeById(@PathVariable int id) {
        return ResponseEntity.ok(documentTypeService.getDocumentTypeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDocumentType(@PathVariable int id) {
        documentTypeService.deleteDocumentType(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentTypePojo> updateDocumentType(@PathVariable int id, @RequestBody DocumentTypeDto documentTypeDto) {
        return ResponseEntity.ok(documentTypeService.updateDocumentType(id, documentTypeDto));
    }
}
