package nhs.apitutorial.controller;

import lombok.Data;

@Data
public class Hello {
    private String message;

    public Hello(String message) {
        this.message = message;
    }
}
