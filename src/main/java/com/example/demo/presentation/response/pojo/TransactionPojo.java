package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionPojo {

  private int id;
  private String socialReason;
  private String documentNumber;
  private Double amount;
  private Boolean isIncome;
  private String description;
  private String date;
  private Integer documentTypeId;
  private String documentType;

}
