package com.avram.testProject.dto.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

@AllArgsConstructor
@Getter
@Setter
public class CreatePetResponse extends BaseResponse {
    private PetBean petBean;

    public CreatePetResponse(Integer code, String message) {
        super(code, message);
    }

    public CreatePetResponse(Integer code, String message, PetBean petBean) {
        super(code, message);
        this.petBean = petBean;
    }
}
