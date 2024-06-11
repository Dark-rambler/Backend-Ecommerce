package com.example.demo.presentation.controller;

import com.example.demo.domain.service.interfaces.ExpenseService;
import com.example.demo.presentation.request.dto.ExpenseDto;
import com.example.demo.presentation.response.pojo.ExpensePojo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpensePojo>> getAll() {
        List<ExpensePojo> expenses = expenseService.getAllExpenses();
        return ResponseEntity.status(HttpStatus.OK).body(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpensePojo> createExpense( @PathVariable Integer id) {
        ExpensePojo expense = expenseService.getExpense(id);
        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @PostMapping()
    public ResponseEntity<ExpensePojo> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpensePojo expense = expenseService.createExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }
}
