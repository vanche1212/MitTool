package com.zrtg.mittoolcore.service.impl;

import com.dtflys.forest.config.ForestConfiguration;
import com.zrtg.mittoolcore.annotation.ForestResult;
import com.zrtg.mittoolcore.client.SobeyHiveFpClient;
import com.zrtg.mittoolcore.client.SobeySolarClient;
import com.zrtg.mittoolcore.model.entity.fp.QueryResultVO;
import com.zrtg.mittoolcore.model.entity.fp.UserVO;
import com.zrtg.mittoolcore.model.entity.solar.Channel;
import com.zrtg.mittoolcore.service.MitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MitServiceImpl implements MitService {

    private Logger logger = LoggerFactory.getLogger(MitServiceImpl.class);

    private ForestConfiguration forestConfiguration;

    public MitServiceImpl(ForestConfiguration forestConfiguration) {
        this.forestConfiguration = forestConfiguration;
    }

    @ForestResult
    @Override
    public List<Channel> getSolarChannelColumn(String token) {
        SobeySolarClient sobeySolarClient = forestConfiguration.createInstance(SobeySolarClient.class);
        return sobeySolarClient.getSolarColumn(token);
    }

    @ForestResult
    @Override
    public QueryResultVO getUserInfoByRoleName(String site, String token, String roleName) {
        SobeyHiveFpClient sobeyHiveFpClient = forestConfiguration.createInstance(SobeyHiveFpClient.class);
        return sobeyHiveFpClient.getUserInfoByRoleName(site, token, roleName);
    }

    @ForestResult
    @Override
    public UserVO getCurrentUserInfo(String site, String token) {
        SobeyHiveFpClient sobeyHiveFpClient = forestConfiguration.createInstance(SobeyHiveFpClient.class);
        return sobeyHiveFpClient.getCurrentUserInfo(site, token);
    }


}
