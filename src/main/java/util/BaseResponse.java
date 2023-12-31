package util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BaseResponse {
    private Integer code;
    private String message;
    private Object object;

    public BaseResponse(Integer code,
                        String message,
                        Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}