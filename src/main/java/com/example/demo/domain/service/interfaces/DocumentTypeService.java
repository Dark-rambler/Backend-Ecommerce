package com.example.demo.domain.service.interfaces;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;

import java.util.List;

public interface DocumentTypeService extends CRUDService<DocumentType, Integer> {
    DocumentType create (DocumentTypeDto dto);
    DocumentType update (Integer id, DocumentTypeDto dto);
    DocumentTypePojo getPojoById (Integer id);
    void delete (Integer id);

    List<DocumentTypePojo> search();
}
