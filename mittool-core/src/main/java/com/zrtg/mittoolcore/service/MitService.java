package com.zrtg.mittoolcore.service;

import com.zrtg.mittoolcore.model.sobey.solar.Channel;

import java.util.List;

public interface MitService {

    /**
     * 获取索贝solar栏目配置
     */
    List<Channel> getSolarColumn(String token);




}
