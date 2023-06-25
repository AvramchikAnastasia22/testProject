package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PetBean;

import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

import java.util.List;

@Getter
@Setter
public class GetAllPetResponse extends BaseResponse {
    private List<PetBean> petBeans;

    public GetAllPetResponse(Integer code, String message) {
        super(code, message);
    }

    public GetAllPetResponse(Integer code, String message, List<PetBean> petBeans) {
        super(code, message);
        this.petBeans = petBeans;
    }
}

