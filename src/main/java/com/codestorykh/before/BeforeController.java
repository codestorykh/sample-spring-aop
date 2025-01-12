package com.codestorykh.before;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeforeController {

    @GetMapping("/before/auditable")
    @BeforeAuditable
    public String beforeAuditable() throws InterruptedException {
        System.out.println("Before Auditable");
        return "Before Auditable";
    }
}
