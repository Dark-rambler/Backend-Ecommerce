package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import org.springframework.stereotype.Component;

@Component
public class DocumentTypeMapper {
    public DocumentType fromDto(DocumentTypeDto documentTypeDto){
        DocumentType documentType = new DocumentType();
        documentType.setName(documentTypeDto.getName());
        documentType.setDescription(documentTypeDto.getDescription());
        return documentType;
    }

    public DocumentType fromDto(DocumentTypeDto dto, DocumentType found){
        found.setName(dto.getName());
        found.setDescription(dto.getDescription());
        return found;
    }
}
