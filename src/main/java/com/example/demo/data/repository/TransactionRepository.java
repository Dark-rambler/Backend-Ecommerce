package com.example.demo.data.repository;

import com.example.demo.domain.entity.Transaction;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends GenericRepository<Transaction, Integer> {
  Optional<Transaction> findByIdAndActive(Integer id, Boolean active);

  @Query(
      "SELECT new com.example.demo.presentation.response.pojo.TransactionPojo"
          + "(t.id, t.documentNumber, t.socialReason,t.amount, t.isIncome, t.description, to_char(t.date, 'DD-MM-YYYY'), d.id, d.name) "
          + "FROM Transaction t "
          + "INNER JOIN t.documentType d "
          + "WHERE t.id = :id AND t.active"
  )
  TransactionPojo getPojoById(Integer id);

  @Query(
      "SELECT new com.example.demo.presentation.response.pojo.TransactionPojo"
          + "(t.id, t.documentNumber, t.socialReason,t.amount, t.isIncome, t.description, to_char(t.date, 'DD-MM-YYYY'), d.id, d.name) "
          + "FROM Transaction t "
          + "INNER JOIN t.documentType d "
          + "WHERE t.active AND t.isIncome = :isIncome "
  )
  List<TransactionPojo> search(Boolean isIncome);
}
