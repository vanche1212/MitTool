package com.zrtg.demo;

import com.zrtg.mittoolcore.model.sobey.solar.Channel;
import com.zrtg.mittoolcore.service.SobeySolarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SobeySolarService sobeySolarService;

    @Test
    void contextLoads() {
        List<Channel> solarColumn = sobeySolarService.getSolarColumn("14a66599ac756c8ef8a7a972b1701fc8e939fe09616ed9f5b2439f23cb7a2bab");
        System.out.println(solarColumn);
    }


}
