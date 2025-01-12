package com.codestorykh.after;

import com.codestorykh.before.BeforeAuditable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AfterController {

    @GetMapping("/after/auditable")
    @BeforeAuditable
    @AfterAuditable
    public String afterAuditable() {
        return "Before and After Auditable";
    }
}
