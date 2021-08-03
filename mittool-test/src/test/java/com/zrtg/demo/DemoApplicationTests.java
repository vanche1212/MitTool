package com.zrtg.demo;

import com.zrtg.mittoolcorebluecloudapi.client.SobeyHiveFpClient;
import com.zrtg.mittoolcorebluecloudapi.model.dto.fp.User;
import com.zrtg.mittoolcoreldap.entity.Department;
import com.zrtg.mittoolcoreldap.service.LdapServiceFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {


//    @Autowired
//    private TestService testService;

//    @Autowired
//    private MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean;

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private LdapServiceFacade xsLdapService;

    @Autowired
    private SobeyHiveFpClient sobeyHiveFpClient;

    @Autowired
    private HiClient hiClient;

    @Test
    void contextLoads() throws Exception {
//        List<User> users = userMapper.getUsers();

//        List<User> users = userMapper.selectList(null);


//        String sdf = testService.test();


//        List<Department> allDepartment = xsLdapService.getAllDepartment();

//        myBatisPlusGenerator.start("abs", "ums_role");
        User zrtg_mit = sobeyHiveFpClient.getCurrentUserInfo("zrtg_mit", "217fd55efe4461147f97123e092047a52d500aa258ef21bb7347f31ba678019c");

        String sss = hiClient.sss();

        System.out.println("123");

    }


}
