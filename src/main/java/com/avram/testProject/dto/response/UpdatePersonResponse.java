package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PersonBean;

import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

@Getter
@Setter
public class UpdatePersonResponse extends BaseResponse {
    private PersonBean personBean;

    public UpdatePersonResponse(Integer code, String message, PersonBean personBean) {
        super(code, message);
        this.personBean = personBean;
    }
}
