package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Pojo
@NoArgsConstructor
@Getter
@Setter
public class ExpensePojo {
    private int id;
    private String name;
    private String description;
    private double amount;
    private Date date;
}
