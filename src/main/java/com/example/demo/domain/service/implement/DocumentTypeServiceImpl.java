package com.example.demo.domain.service.implement;

import com.example.demo.common.SpanishEntityNameProvider;
import com.example.demo.data.repository.DocumentTypeRepository;
import com.example.demo.data.repository.GenericRepository;
import com.example.demo.domain.entity.DocumentType;
import com.example.demo.domain.mapper.DocumentTypeMapper;
import com.example.demo.domain.service.interfaces.DocumentTypeService;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.presentation.request.dto.DocumentTypeDto;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocumentTypeServiceImpl extends CRUDServiceImpl<DocumentType, Integer> implements DocumentTypeService{

    private final DocumentTypeRepository repository;
    private final DocumentTypeMapper mapper;

    private static final String DOCUMENT_TYPE = SpanishEntityNameProvider.getSpanishName("DocumentType");

    @Override
    protected GenericRepository<DocumentType, Integer> getRepository() {
        return repository;
    }

    @Override
    public DocumentType create(DocumentTypeDto dto) {
        return super.create(mapper.fromDto(dto));
    }

    @Override
    public DocumentType update(Integer id, DocumentTypeDto dto) {
        DocumentType found = repository.findByIdAndActive(id, true)
                .orElseThrow(() -> new EntityNotFoundException(DOCUMENT_TYPE, id));
        return repository.save(mapper.fromDto(dto, found));
    }

    @Override
    public DocumentTypePojo getPojoById(Integer id) {
        return repository.getPojoById(id);
    }

    @Override
    public List<DocumentTypePojo> search() {
        return repository.search();
    }
}
