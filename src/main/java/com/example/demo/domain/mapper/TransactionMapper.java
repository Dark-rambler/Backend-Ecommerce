package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.Transaction;
import com.example.demo.presentation.request.dto.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
  public Transaction fromDto(TransactionDto transactionDto) {
    Transaction entity = new Transaction();
    entity.setIsIncome(transactionDto.getIsIncome());
    entity.setAmount(transactionDto.getAmount());
    entity.setDescription(transactionDto.getDescription());
    entity.setDate(transactionDto.getDate());
    entity.setDocumentNumber(transactionDto.getDocumentNumber());
    entity.setSocialReason(transactionDto.getSocialReason());
    return entity;
  }

  public Transaction fromDto(TransactionDto transactionDto, Transaction found) {
    found.setIsIncome(transactionDto.getIsIncome());
    found.setAmount(transactionDto.getAmount());
    found.setDescription(transactionDto.getDescription());
    found.setDate(transactionDto.getDate());
    found.setDocumentNumber(transactionDto.getDocumentNumber());
    found.setSocialReason(transactionDto.getSocialReason());
    return found;
  }
}
