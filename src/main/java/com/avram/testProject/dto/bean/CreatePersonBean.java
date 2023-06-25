package com.avram.testProject.dto.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreatePersonBean {
    private Integer id;
    private String name;

    private String lastName;

    private String address;

    private String numberPhone;

    private String town;
}
