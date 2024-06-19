package com.example.demo.domain.service.interfaces;

import com.example.demo.domain.entity.Transaction;
import com.example.demo.presentation.request.dto.TransactionDto;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import java.util.List;

public interface TransactionService extends CRUDService<Transaction, Integer> {
  Transaction create(TransactionDto dto);
  Transaction update(Integer id, TransactionDto dto);
  TransactionPojo getPojoById(Integer id);
  void delete(Integer id);
  List<TransactionPojo> search();
}
