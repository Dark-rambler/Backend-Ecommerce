package com.example.demo.domain.service.implement;

import com.example.demo.data.repository.ExpenseRepository;
import com.example.demo.domain.entity.DocumentType;
import com.example.demo.domain.entity.Expense;
import com.example.demo.domain.mapper.ExpenseMapper;
import com.example.demo.domain.service.interfaces.DocumentTypeService;
import com.example.demo.domain.service.interfaces.ExpenseService;
import com.example.demo.presentation.request.dto.ExpenseDto;
import com.example.demo.presentation.response.pojo.ExpensePojo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {
    /*private final ExpenseRepository expenseRepository;
    private final DocumentTypeService documentTypeService;
    private final ExpenseMapper expenseMapper;

    @Override
    public ExpensePojo createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.fromDto(expenseDto);
        DocumentType documentType = documentTypeService.getDocumentType(expenseDto.getDocumentTypeId());
        expense.setDocumentType(documentType);
        expenseRepository.save(expense);
        return expenseMapper.toPojo(expense);
    }

    @Override
    public ExpensePojo updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.fromDto(expenseDto);
        expenseRepository.save(expense);
        return expenseMapper.toPojo(expense);
    }

    @Override
    public void deleteExpense(int id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Expense", id));
        expenseRepository.deleteById(id);
    }

    @Override
    public ExpensePojo getExpense(int id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Expense", id));
        return expenseMapper.toPojo(expense);
    }

    @Override
    public List<ExpensePojo> getAllExpenses() {
        List<Expense> expenseList = expenseRepository.findAll();
        return toPojoList(expenseList);
    }

    private List<ExpensePojo> toPojoList(List<Expense> expenseList) {
        List<ExpensePojo> expensePojoList = expenseList.stream().map((entity)->
                expenseMapper.toPojo(entity)).toList();
        return expensePojoList;
    }*/
}
