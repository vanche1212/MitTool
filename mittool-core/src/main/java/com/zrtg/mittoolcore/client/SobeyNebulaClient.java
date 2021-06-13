package com.zrtg.mittoolcore.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcore.model.entity.solar.Channel;

import java.util.List;

@BaseRequest(
        baseURL = "http://cbc.zrtg.com:88"
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
