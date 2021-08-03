package com.zrtg.demo;

import com.zrtg.mittoolcorelog.annotation.WebLog;
import org.springframework.web.bind.annotation.*;

@WebLog
@RestController
public class TestController {

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") String s, @RequestParam String a) {
        return "123";
    }

}

