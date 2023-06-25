package com.avram.testProject.dto.request;

import com.avram.testProject.dto.bean.PetBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CreatePetRequest {
    private PetBean petBean;

    public CreatePetRequest(PetBean petBean) {
        this.petBean = petBean;
    }
}
