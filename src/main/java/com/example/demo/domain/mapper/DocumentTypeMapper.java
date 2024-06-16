package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper {

    public DocumentTypePojo toPojo(DocumentType documentType ) {
        DocumentTypePojo documentTypePojo = new DocumentTypePojo();
        documentTypePojo.setId(documentType.getId());
        documentTypePojo.setName(documentType.getName());
        documentTypePojo.setDescription(documentType.getDescription());
        return documentTypePojo;
    }

    public DocumentType fromPojo(DocumentTypePojo documentTypePojo ) {
        DocumentType documentType = new DocumentType();
        documentType.setId(documentTypePojo.getId());
        documentType.setName(documentTypePojo.getName());
        documentType.setDescription(documentTypePojo.getDescription());
        return documentType;
    }

    public DocumentType fromDto(DocumentTypeDto documentTypeDto){
        DocumentType documentType = new DocumentType();
        documentType.setName(documentTypeDto.getName());
        documentType.setDescription(documentTypeDto.getDescription());
        return documentType;
    }

    public DocumentType toDto(DocumentTypeDto documentTypeDto){
        DocumentType documentType = new DocumentType();
        documentType.setName(documentTypeDto.getName());
        documentType.setDescription(documentTypeDto.getDescription());
        return documentType;
    }


}
