package com.example.demo.domain.service.implement;

import com.example.demo.common.SpanishEntityNameProvider;
import com.example.demo.data.repository.DocumentTypeRepository;
import com.example.demo.data.repository.GenericRepository;
import com.example.demo.data.repository.TransactionRepository;
import com.example.demo.domain.entity.DocumentType;
import com.example.demo.domain.entity.Transaction;
import com.example.demo.domain.mapper.TransactionMapper;
import com.example.demo.domain.service.interfaces.TransactionService;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.presentation.request.dto.TransactionDto;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl extends CRUDServiceImpl<Transaction, Integer> implements
    TransactionService {

  private final TransactionRepository repository;
  private final TransactionMapper mapper;
  private final DocumentTypeRepository documentTypeRepository;

  private static final String TRANSACTION = SpanishEntityNameProvider.getSpanishName("Transaction");
  private static final String DOCUMENT_TYPE = SpanishEntityNameProvider.getSpanishName("DocumentType");
  @Override
  protected GenericRepository<Transaction, Integer> getRepository() {
    return repository;
  }

  @Override
  public Transaction create(TransactionDto dto) {
    DocumentType documentType = documentTypeRepository.findByIdAndActive(dto.getDocumentTypeId(), true)
        .orElseThrow(() -> new EntityNotFoundException(TRANSACTION, dto.getDocumentTypeId()));

    Transaction transaction = mapper.fromDto(dto);
    transaction.setDocumentType(documentType);

    return super.create(transaction);
  }

  @Override
  public Transaction update(Integer id, TransactionDto dto) {
    Transaction found = repository.findByIdAndActive(id, true)
        .orElseThrow(() -> new EntityNotFoundException(TRANSACTION, id));

    DocumentType documentType = documentTypeRepository.findByIdAndActive(dto.getDocumentTypeId(), true)
        .orElseThrow(() -> new EntityNotFoundException(DOCUMENT_TYPE, dto.getDocumentTypeId()));

    Transaction transaction = mapper.fromDto(dto, found);
    transaction.setDocumentType(documentType);

    return found;
  }

  @Override
  public TransactionPojo getPojoById(Integer id) {
    return repository.getPojoById(id);
  }

  @Override
  public void delete(Integer id) {
    Transaction transaction = repository.findByIdAndActive(id, true)
        .orElseThrow(() -> new EntityNotFoundException(TRANSACTION, id));

    transaction.setActive(false);
    repository.save(transaction);
  }

  @Override
  public List<TransactionPojo> search( Boolean isIncome) {
    return repository.search(isIncome);
  }


}
