package com.example.demo.domain.service.interfaces;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;

import java.util.List;

public interface DocumentTypeService {

    DocumentTypePojo createDocumentType(DocumentTypeDto documentTypeDto);

    List<DocumentTypePojo> getAll();

    DocumentTypePojo getDocumentTypeById(int id);

    void deleteDocumentType(int id);

    DocumentTypePojo updateDocumentType(int id, DocumentTypeDto documentTypeDto);

    DocumentType getDocumentType(int id);


}
