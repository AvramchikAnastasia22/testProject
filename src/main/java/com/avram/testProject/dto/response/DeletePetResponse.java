package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.dto.bean.PetBean;
import util.BaseResponse;

public class DeletePetResponse extends BaseResponse {
    PetBean petBean;

    public DeletePetResponse(Integer code, String message) {
        super(code, message);
    }

    public DeletePetResponse(Integer code, String message, PetBean petBean) {
        super(code, message);
        this.petBean = petBean;
    }
}