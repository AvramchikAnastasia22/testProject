package com.avram.testProject.dto.bean;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PetBean {
    private Integer id;
    private String nickName;
    private Integer age;
    private String typePet;
    private String gender;
    private Double weight;
    private Integer personId;
}
