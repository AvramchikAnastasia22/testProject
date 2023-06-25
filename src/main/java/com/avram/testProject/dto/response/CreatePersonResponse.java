package com.avram.testProject.dto.response;

import lombok.Getter;
import lombok.Setter;
import util.BaseResponse;
@Getter
@Setter
public class CreatePersonResponse extends BaseResponse {
    private CreatePersonResponse createPersonResponse;

    public CreatePersonResponse(Integer code, String message) {
        super(code, message);
    }

    public CreatePersonResponse(Integer code, String message, Object object, CreatePersonResponse createPersonResponse) {
        super(code, message, object);
        this.createPersonResponse = createPersonResponse;
    }
}
