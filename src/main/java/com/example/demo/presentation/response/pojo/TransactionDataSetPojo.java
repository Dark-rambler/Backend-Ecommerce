package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@Getter
@Setter
@NoArgsConstructor
public class TransactionDataSetPojo {
  private String label;
  private List<Double> data;
}
