package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Pojo
@NoArgsConstructor
@Getter
@Setter
public class CategoryPojo {
    private int id;
    private String name;
}
