package com.avram.testProject.dto.response;

import com.avram.testProject.dto.bean.PersonBean;
import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;

import java.util.List;
@Getter
@Setter
public class GetAllPersonResponse extends BaseResponse {
    List<PersonBean> personBeans;

    public GetAllPersonResponse(Integer code, String message) {
        super(code, message);
    }

    public GetAllPersonResponse(Integer code, String message, List<PersonBean> personBeans) {
        super(code, message);
        this.personBeans = personBeans;
    }
}
