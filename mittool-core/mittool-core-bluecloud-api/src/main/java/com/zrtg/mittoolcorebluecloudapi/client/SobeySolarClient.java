package com.zrtg.mittoolcorebluecloudapi.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcorebluecloudapi.model.dto.solar.Channel;

import java.util.List;


/**
 * 索贝蓝云solar服务
 */
@BaseRequest(
        baseURL = "http://10.20.54.100:88"
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

//    /**
//     * 获取Solar系统工具参数
//     */
//    @Request(
//            url = "/solar-api/systemtool/tree",
//            headers = {"sobeyhive-http-token: ${0}"},
//            dataType = "json"
//    )
//    SobeySolarSystemTree getSystemToolTree(String token);
//
//    /**
//     * 添加Solar系统工具参数的操作权限
//     */
//    @Request(
//            url = "/solar-api/systemtool/system/${0}/_global_popedomdef/${1}",
//            headers = {"sobeyhive-http-token: ${2}"},
//            dataType = "json"
//    )
//    SobeySolarSystemTreeOperatePermission addSystemToolOperatePermission(Integer systemId, String systemCode, String token);


}
