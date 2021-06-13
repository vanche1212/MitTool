package com.zrtg.demo;

import com.zrtg.mittoolcore.annotation.WebLog;
import org.springframework.stereotype.Service;

@WebLog
@Service
public class TestService {

    public String test(String a) {
        System.out.println(a);
        return "hehe";
    }

}
