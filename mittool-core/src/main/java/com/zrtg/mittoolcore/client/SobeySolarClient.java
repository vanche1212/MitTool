package com.zrtg.mittoolcore.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcore.model.sobey.solar.Channel;

import java.util.List;

@BaseRequest(
        baseURL = "http://cbc.zrtg.com:88"
)
public interface SobeySolarClient {



    /**
     * 获取索贝租户栏目
     */
    @Request(
            url = "/solar-api/channel",
            headers = {"sobeyhive-http-token:${0}"},
            dataType = "json"
    )
    List<Channel> getSolarColumn(String token);


}
