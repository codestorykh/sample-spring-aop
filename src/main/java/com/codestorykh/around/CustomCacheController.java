package com.codestorykh.around;

import com.codestorykh.before.BeforeAuditable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomCacheController {

    @CustomCache
    @BeforeAuditable
    @GetMapping("/custom/cache")
    public String customCache() throws InterruptedException {
        Thread.sleep(1000);
        return "Custom Cache";
    }
}
