package com.zrtg.mittoolcore.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcore.model.entity.fp.QueryResultVO;
import com.zrtg.mittoolcore.model.entity.fp.UserVO;

@BaseRequest(
        baseURL = "http://cbc.zrtg.com:88/sobeyhive-fp"
)
public interface SobeyHiveFpClient {

    /**
     * 根据角色名称，查询角色包含的用户列表
     */
    @Request(
            url = "/v1/kernel/configs/role/rolename/${2}/users",
            headers = {"sobeyhive-http-site: ${0}", "sobeyhive-http-token: ${1}"},
            type = "get",
            dataType = "json"
    )
    QueryResultVO getUserInfoByRoleName(String site, String token, String roleName);


    /**
     * 获取当前登陆用户信息
     */
    @Request(
            url = "/v1/kernel/configs/user/current",
            headers = {"sobeyhive-http-site: ${0}","sobeyhive-http-token: ${1}"},
            type = "get",
            dataType = "json"
    )
    UserVO getCurrentUserInfo(String site, String token);


}
