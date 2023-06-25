package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PetBean;

import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

@Getter
@Setter
public class UpdaterPetResponse extends BaseResponse {
    private PetBean petBean;

    public UpdaterPetResponse(Integer code, String message) {
        super(code, message);
    }

    public UpdaterPetResponse(Integer code, String message, PetBean petBean) {
        super(code, message);
        this.petBean = petBean;
    }
}
