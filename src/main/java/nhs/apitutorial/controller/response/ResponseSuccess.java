package nhs.apitutorial.controller.response;

import lombok.Data;

@Data
public class ResponseSuccess implements ResponseData{
    private final String message;

    public ResponseSuccess(String message) {
        this.message = "Hello " + message;
    }

}
