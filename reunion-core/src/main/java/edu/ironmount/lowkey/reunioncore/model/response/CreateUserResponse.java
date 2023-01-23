package edu.ironmount.lowkey.reunioncore.model.response;

import lombok.Data;

@Data(staticConstructor = "of")
public class CreateUserResponse {
    private final Integer statusCode;
    private final String comment;
    private final String errorMsg;
}
