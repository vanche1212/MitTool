package com.zrtg.mittoolcorebluecloudapi.client;

import com.dtflys.forest.annotation.BaseRequest;

/**
 * 索贝蓝云nebula服务
 */
@BaseRequest(
        baseURL = "http://10.20.54.100:88"
)
public interface SobeyNebulaClient {


//    /**
//     * 添加Nebula第三方应用
//     */
//    @Request(
//            url = "/nebula-api/application/add",
//            headers = {"sobeyhive-http-token: ${0}"},
//            type = "post",
//            dataType = "json"
//    )
//    SobeyNebulaApplication addNebulaApplication(String token, @Body NebulaApplicationDTO nebulaApplicationDTO);



}
