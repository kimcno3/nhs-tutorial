package nhs.apitutorial.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class NhsController {

    // 임의 키 설정
    private final static String API_KEY = "12345";
    private final static String BEARER_TOKEN = "abc";

    // 1단계
    @GetMapping("/world")
    public ResponseEntity<Hello> helloWorld(){
        return new ResponseEntity(new Hello("Hello world!"), HttpStatus.OK);
    }

    // 2단계
    @GetMapping("/application")
    public ResponseEntity<Hello> helloApplication(@RequestHeader(value = "apikey") String apiKey){
        if (apiKey.equals(API_KEY)) {
            return new ResponseEntity(new Hello("Hello application!"), HttpStatus.OK);
        } else{
            return new ResponseEntity(new Hello("Invalid Api Key!"), HttpStatus.UNAUTHORIZED);
        }
    }

    // 3단계
    @GetMapping("/user")
    public ResponseEntity<Hello> helloUser(@RequestHeader(value = "Authorization") String authorization) {
        if(authorization.equals("Bearer " + BEARER_TOKEN)){
            return new ResponseEntity(new Hello("Hello User!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new Hello("Invalid Bearer Token!"), HttpStatus.UNAUTHORIZED);
        }
    }
    
    @Data
    static class Hello {
        private String message;

        public Hello(String message) {
            this.message = message;
        }
    }
}