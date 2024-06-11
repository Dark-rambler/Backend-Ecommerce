package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.Expense;
import com.example.demo.presentation.request.dto.ExpenseDto;
import com.example.demo.presentation.response.pojo.ExpensePojo;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public ExpensePojo toPojo(Expense expense ) {
        ExpensePojo expensePojo = new ExpensePojo();
        expensePojo.setId(expense.getId());
        expensePojo.setName(expense.getName());
        expensePojo.setDate(expense.getDate());
        expensePojo.setAmount(expense.getAmount());
        expensePojo.setDescription(expense.getDescription());
        return expensePojo;
    }

    public Expense fromPojo(ExpensePojo expensePojo ) {
        Expense expense = new Expense();
        expense.setId(expensePojo.getId());
        expense.setName(expensePojo.getName());
        expense.setDate(expensePojo.getDate());
        expense.setAmount(expensePojo.getAmount());
        expense.setDescription(expensePojo.getDescription());
        return expense;
    }

    public Expense fromDto(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setDate(expenseDto.getDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setDescription(expenseDto.getDescription());
        return expense;
    }

    public Expense toDto(ExpenseDto expenseDto){
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setDate(expenseDto.getDate());
        expense.setAmount(expenseDto.getAmount());
        expense.setDescription(expenseDto.getDescription());
        return expense;
    }

}
