package com.example.demo.domain.service.implement;

import com.example.demo.data.repository.DocumentTypeRepository;
import com.example.demo.domain.entity.DocumentType;
import com.example.demo.domain.mapper.DocumentTypeMapper;
import com.example.demo.domain.service.interfaces.DocumentTypeService;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private  DocumentTypeRepository documentTypeRepository;
    private  DocumentTypeMapper documentTypeMapper;
    @Override
    public DocumentTypePojo createDocumentType(DocumentTypeDto documentTypeDto) {
    DocumentTypePojo documentTypePojo = documentTypeMapper.toPojo(documentTypeRepository.save(documentTypeMapper.fromDto(documentTypeDto)));
    return documentTypePojo;
    }

    @Override
    public List<DocumentTypePojo> getAll() {
        List<DocumentType> documentTypeList = documentTypeRepository.findAll();
        return toPojoList(documentTypeList);

    }

    @Override
    public DocumentTypePojo getDocumentTypeById(int id) {
        DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Document Type not found" + id));
        return documentTypeMapper.toPojo(documentType);
    }

    @Override
    public void deleteDocumentType(int id) {
        DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Document Type not found" + id));
        if (documentType != null) {
            documentTypeRepository.delete(documentType);
        }

    }

    @Override
    public DocumentTypePojo updateDocumentType(int id, DocumentTypeDto documentTypeDto) {
        DocumentType documentType = documentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Document Type not found" + id));
        documentType.setName(documentTypeDto.getName());
        documentType.setDescription(documentTypeDto.getDescription());
        DocumentTypePojo documentTypePojo = documentTypeMapper.toPojo(documentTypeRepository.save(documentType));
        return documentTypePojo;
    }

    @Override
    public DocumentType getDocumentType(int id) {
        return documentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Document Type not found" + id));
    }


    private List<DocumentTypePojo> toPojoList(List<DocumentType> documentTypeList) {
        List<DocumentTypePojo> documentTypePojoList = documentTypeList.stream().map((entity)->
                documentTypeMapper.toPojo(entity)).toList();
        return documentTypePojoList;
    }
}
