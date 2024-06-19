package com.example.demo.presentation.request.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDto {
  @NotNull(message = "{transactionDto.amount.not-null}")
  private Double amount;

  @NotNull(message = "{transactionDto.isIncome.not-null}")
  private Boolean isIncome;

  @NotNull(message = "{transactionDto.description.not-null}")
  private String description;

  @NotNull(message = "{transactionDto.date.not-null}")
  private LocalDateTime date;

  @NotNull(message = "{transactionDto.documentTypeId.not-null}")
  private Integer documentTypeId;


}
