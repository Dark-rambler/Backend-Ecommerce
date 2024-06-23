package com.example.demo.data.repository;

import com.example.demo.domain.entity.Transaction;
import com.example.demo.presentation.response.pojo.TransactionMonthlySummaryPojo;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
          + "(t.id,t.socialReason, t.documentNumber, t.amount, t.isIncome, t.description, to_char(t.date, 'DD-MM-YYYY'), d.id, d.name) "
          + "FROM Transaction t "
          + "INNER JOIN t.documentType d "
          + "WHERE t.active AND t.isIncome = :isIncome "
  )
  List<TransactionPojo> search(Boolean isIncome);

  @Query("SELECT new com.example.demo.presentation.response.pojo.TransactionPojo"
      + "(t.id, t.socialReason, t.documentNumber, t.amount, t.isIncome, t.description, to_char(t.date, 'DD-MM-YYYY'), d.id, d.name) "
      + "FROM Transaction t "
      + "INNER JOIN t.documentType d "
      + "WHERE t.isIncome = :isIncome AND t.date BETWEEN :startDate AND :endDate")
  List<TransactionPojo> findTransactionsByDateRangeAndIsIncome(
      @Param("isIncome") boolean isIncome,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate);

  @Query("SELECT " +
      "YEAR(t.date) AS year, " +
      "MONTH(t.date) AS month, " +
      "SUM(CASE WHEN t.isIncome = true THEN t.amount ELSE 0 END) AS totalIncome, " +
      "SUM(CASE WHEN t.isIncome = false THEN t.amount ELSE 0 END) AS totalExpense " +
      "FROM Transaction t " +
      "WHERE t.date BETWEEN :startDate AND :endDate " +
      "GROUP BY YEAR(t.date), MONTH(t.date) " +
      "ORDER BY YEAR(t.date), MONTH(t.date)")
  List<Object[]> findMonthlySummary(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate);
}
