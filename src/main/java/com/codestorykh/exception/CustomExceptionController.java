package com.codestorykh.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomExceptionController {

    @GetMapping("/custom/exception")
    public String customException() {
        throw new RuntimeException("Custom Exception");
    }
}
