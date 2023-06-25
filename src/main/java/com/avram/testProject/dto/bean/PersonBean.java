package com.avram.testProject.dto.bean;

import com.avram.testProject.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PersonBean {
private Integer id;
    private String name;
    private String lastName;

    private String address;
    private String numberPhone;
    private String town;
    private List<Pet> pets;


}
