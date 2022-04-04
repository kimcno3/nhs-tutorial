package nhs.apitutorial.controller;

import lombok.Data;
import nhs.apitutorial.controller.response.ResponseData;
import nhs.apitutorial.controller.response.ResponseError;
import nhs.apitutorial.controller.response.ResponseSuccess;
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
    public ResponseEntity<ResponseData> helloWorld(){
        return new ResponseEntity(new ResponseSuccess("world!"), HttpStatus.OK);
    }

    // 2단계
    @GetMapping("/application")
    public ResponseEntity<ResponseData> helloApplication(@RequestHeader(value = "apikey") String apiKey){
        if (apiKey.equals(API_KEY)) {
            return new ResponseEntity(new ResponseSuccess("application!"), HttpStatus.OK);
        } else{
            return new ResponseEntity(new ResponseError("Api Key!"), HttpStatus.UNAUTHORIZED);
        }
    }

    // 3단계
    @GetMapping("/user")
    public ResponseEntity<ResponseData> helloUser(@RequestHeader(value = "Authorization") String authorization) {
        if(authorization.equals("Bearer " + BEARER_TOKEN)){
            return new ResponseEntity(new ResponseSuccess("User!"), HttpStatus.OK);
        } else {
            return new ResponseEntity(new ResponseError("Bearer Token!"), HttpStatus.UNAUTHORIZED);
        }
    }
}