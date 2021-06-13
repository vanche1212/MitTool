package com.zrtg.demo;

import com.zrtg.mittool.generator.MyBatisPlusGenerator;
import com.zrtg.mittoolcore.model.entity.fp.QueryResultVO;
import com.zrtg.mittoolcore.model.entity.solar.Channel;
import com.zrtg.mittoolcore.service.MitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MitService mitService;

    @Autowired
    TestService testService;

//    @Autowired
//    MyBatisPlusGenerator myBatisPlusGenerator;

    @Test
    void contextLoads() {

        String asf = testService.test("asf");

//        System.out.println("123");

    }


}
