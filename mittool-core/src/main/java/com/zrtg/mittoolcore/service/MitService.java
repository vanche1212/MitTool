package com.zrtg.mittoolcore.service;

import com.zrtg.mittoolcore.model.entity.fp.QueryResultVO;
import com.zrtg.mittoolcore.model.entity.fp.UserVO;
import com.zrtg.mittoolcore.model.entity.solar.Channel;

import java.util.List;

public interface MitService {

    /**
     * 获取索贝solar频道栏目配置
     */
    List<Channel> getSolarChannelColumn(String token);

    /**
     * 获取指定角色的所有用户信息
     */
    QueryResultVO getUserInfoByRoleName(String site, String token, String roleName);

    /**
     * 获取当前登陆用户信息
     */
    UserVO getCurrentUserInfo(String site, String token);

}
