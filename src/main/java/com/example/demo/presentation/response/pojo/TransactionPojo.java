package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Pojo
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPojo {

  private int id;
  private Double amount;
  private Boolean isIncome;
  private String description;
  private String date;
  private Integer documentTypeId;
  private String documentType;

}
