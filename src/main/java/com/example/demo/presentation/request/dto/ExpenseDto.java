package com.example.demo.presentation.request.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ExpenseDto {
    @NotNull(message = "{expense.name.not-null}")
    @NotBlank(message = "{expense.name.not-blank}")
    private String name;
    private String description;
    @NotNull(message = "{expense.amount.not-null}")
    private double amount;
    @NotNull(message = "{expense.date.not-null}")
    @NotBlank(message = "{expense.date.not-blank}")
    private Date date;
    @NotNull(message = "{expense.categoryId.not-null}")
    private int documentTypeId;
}
