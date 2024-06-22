package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Pojo
@Getter
@Setter
public class DocumentTypePojo {
    private Integer id;
    private String name;
    private String description;
}
