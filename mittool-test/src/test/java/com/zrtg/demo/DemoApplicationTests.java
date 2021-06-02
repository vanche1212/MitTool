package com.zrtg.demo;

import com.zrtg.mittool.generator.MyBatisPlusGenerator;
import com.zrtg.mittoolcore.model.sobey.solar.Channel;
import com.zrtg.mittoolcore.service.MitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MitService mitService;

    @Autowired(required = false)
    MyBatisPlusGenerator myBatisPlusGenerator;

    @Test
    void contextLoads() {

//        myBatisPlusGenerator.start("admin", "ums_admin");
//        System.out.println("123");
    }


}
