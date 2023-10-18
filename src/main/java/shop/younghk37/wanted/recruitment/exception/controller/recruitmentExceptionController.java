package shop.younghk37.wanted.recruitment.exception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.younghk37.wanted.recruitment.exception.IllegalRequestException;

@RestControllerAdvice
public class recruitmentExceptionController {

    @ExceptionHandler(IllegalRequestException.class)
    public ResponseEntity<?> signupExceptionHandle(IllegalRequestException exception) {
        return ResponseEntity.badRequest().body(exception.getErrorMap());
    }

}