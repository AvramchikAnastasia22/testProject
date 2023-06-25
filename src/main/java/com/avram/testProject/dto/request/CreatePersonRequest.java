package com.avram.testProject.dto.request;

import com.avram.testProject.dto.bean.CreatePersonBean;
import com.avram.testProject.dto.bean.PersonBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatePersonRequest {
    private PersonBean personBean;
}
