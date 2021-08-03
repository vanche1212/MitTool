package com.zrtg.mittoolcorebluecloudapi.client;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Request;
import com.zrtg.mittoolcorebluecloudapi.model.dto.fp.QueryResult;
import com.zrtg.mittoolcorebluecloudapi.model.dto.fp.User;


/**
 * 索贝fp服务
 */
@BaseRequest(
        baseURL = "http://10.20.54.100:88/sobeyhive-fp"
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
    QueryResult getUserInfoByRoleName(String site, String token, String roleName);


    /**
     * 获取当前登陆用户信息
     */
    @Request(
            url = "/v1/kernel/configs/user/current",
            headers = {"sobeyhive-http-site: ${0}","sobeyhive-http-token: ${1}"},
            type = "get",
            dataType = "json"
    )
    User getCurrentUserInfo(String site, String token);


    /**
     * 登录
     */
    @Request(
            url = "/v2/kernel/configs/user/authentication",
            headers = {"sobeyhive-http-site: ${0}", "sobeyhive-http-system: SobeyHive"},
            type = "get",
            data = "username=${1}&password=${2}",
            dataType = "json"
    )
    User authentication(String site, String username, String password);

}
