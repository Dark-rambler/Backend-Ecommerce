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
import com.example.demo.presentation.response.pojo.TransactionDataSetPojo;
import com.example.demo.presentation.response.pojo.TransactionMonthlySummaryPojo;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import com.example.demo.presentation.response.pojo.TransactionSummaryPojo;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
        .orElseThrow(() -> new EntityNotFoundException(DOCUMENT_TYPE, dto.getDocumentTypeId()));

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

    return transaction;
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

  @Override
  public TransactionSummaryPojo getSummary(LocalDateTime startDate, LocalDateTime endDate) {
    List<TransactionPojo> incomes = repository.findTransactionsByDateRangeAndIsIncome(
        true, startDate, endDate);
    List<TransactionPojo> expenses = repository.findTransactionsByDateRangeAndIsIncome(
        false, startDate, endDate);
    Double totalIncome = incomes.stream().mapToDouble(TransactionPojo::getAmount).sum();
    Double totalExpense = expenses.stream().mapToDouble(TransactionPojo::getAmount).sum();
    Double balance = totalIncome - totalExpense;

    TransactionSummaryPojo summary = new TransactionSummaryPojo();
    summary.setIncomes(incomes);
    summary.setExpenses(expenses);
    summary.setTotalIncome(totalIncome);
    summary.setTotalExpense(totalExpense);
    summary.setBalance(balance);
    return summary;
  }

  @Override
  public TransactionMonthlySummaryPojo getMonthlySummary(LocalDateTime startDate, LocalDateTime endDate) {
    List<Object[]> results = repository.findMonthlySummary(startDate, endDate);

    List<String> labels = new ArrayList<>();
    List<Double> incomeData = new ArrayList<>();
    List<Double> expenseData = new ArrayList<>();

    Map<String, Double[]> dataMap = new HashMap<>();

    for (Object[] result : results) {
      int year = (int) result[0];
      int month = (int) result[1];
      Double totalIncome = (Double) result[2];
      Double totalExpense = (Double) result[3];

      String monthKey = year + "-" + String.format("%02d", month);
      dataMap.put(monthKey, new Double[]{totalIncome, totalExpense});
    }

    LocalDateTime current = startDate.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
    LocalDateTime end = endDate.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);

    while (!current.isAfter(end)) {
      String monthName = current.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + current.getYear();
      labels.add(monthName);

      String monthKey = current.getYear() + "-" + String.format("%02d", current.getMonthValue());
      Double[] values = dataMap.getOrDefault(monthKey, new Double[]{0.0, 0.0});

      incomeData.add(values[0]);
      expenseData.add(values[1]);

      current = current.plusMonths(1);
    }

    TransactionDataSetPojo incomeDataSet = new TransactionDataSetPojo();
    incomeDataSet.setLabel("Income");
    incomeDataSet.setData(incomeData);

    TransactionDataSetPojo expenseDataSet = new TransactionDataSetPojo();
    expenseDataSet.setLabel("Expense");
    expenseDataSet.setData(expenseData);

    List<TransactionDataSetPojo> datasets = new ArrayList<>();
    datasets.add(incomeDataSet);
    datasets.add(expenseDataSet);

    TransactionMonthlySummaryPojo summary = new TransactionMonthlySummaryPojo();
    summary.setLabels(labels);
    summary.setDatasets(datasets);

    return summary;
  }



}
