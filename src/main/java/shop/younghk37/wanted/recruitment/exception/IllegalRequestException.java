package shop.younghk37.wanted.recruitment.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class IllegalRequestException extends RuntimeException{

    Map<String, String> errorMap;
    public IllegalRequestException(String message) {
        errorMap = new HashMap<>();
        errorMap.put("message", message);
    }

    public IllegalRequestException(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

}