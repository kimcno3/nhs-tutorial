package nhs.apitutorial.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class NhsController {

    // 임의 키 설정
    private final static String API_KEY = "12345";
    private final static String BEARER_TOKEN = "abcdefg123456789";

    // Hello 객체 생성
    Hello hello = new Hello();

    // 1단계
    @GetMapping("/hello/world")
    @ResponseBody
    public Hello helloWorld(){
        hello.setMessage("Hello world!");
        return hello;
    }

    // 2단계
    @GetMapping("/hello/application")
    @ResponseBody
    public Hello helloApplication(@RequestHeader(value = "apikey") String apiKey) {

        if (apiKey.equals(API_KEY)) { // 키가 동일한 경우
            hello.setMessage("Hello application!");
        } else{ // 키가 다른 경우
            hello.setMessage("Invalid ApiKey");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        return hello;
    }

    // 3단계
    @GetMapping("/hello/user")
    @ResponseBody
    public Hello helloUser(@RequestHeader(value = "Authorization") String authorization){
        // "Bearer" 문자열 제거
        String token = authorization.split(" ")[1];

        if(token.equals(BEARER_TOKEN)) { // 키가 동일한 경우
            hello.setMessage("Hello user!");
        } else { // 키가 다른 경우
            hello.setMessage("Invalid access token");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
        return hello;
    }

}