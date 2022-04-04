package nhs.apitutorial.controller.response;

import lombok.Data;

@Data
public class ResponseError  implements ResponseData{
    private final String message;

    public ResponseError(String message) {
        this.message = "Invalid " + message;
    }
}
