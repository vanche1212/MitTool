package com.zrtg.mittoolcorebluecloudapi.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2.S6V2;


/**
 * 中国蓝云入库服务
 */
@BaseRequest(
        baseURL = "http://10.20.54.100:19207"
)
public interface MegatewayClient {


    @Request(
            url = "/megateway/api/import/s6v2?site=${0}",
            contentType = "application/json",
            headers = {"systemid: ${1}"},
            type = "post",
            dataType = "json"
    )
    String saveToSearch(String site, String systemId, @Body S6V2 s6V2);


}
