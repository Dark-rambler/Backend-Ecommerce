package com.example.demo.presentation.response.pojo;

import com.example.demo.common.Pojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Pojo
public class DocumentTypePojo {
    private Integer id;
    private String name;
    private String description;
}
