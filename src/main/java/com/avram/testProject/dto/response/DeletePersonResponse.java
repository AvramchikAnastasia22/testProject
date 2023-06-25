package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PersonBean;
import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

@Getter
@Setter
public class DeletePersonResponse extends BaseResponse {
    PersonBean personBean;

    public DeletePersonResponse(Integer code, String message) {
        super(code, message);
    }

    public DeletePersonResponse(Integer code, String message, PersonBean personBean) {
        super(code, message);
        this.personBean = personBean;
    }
}
