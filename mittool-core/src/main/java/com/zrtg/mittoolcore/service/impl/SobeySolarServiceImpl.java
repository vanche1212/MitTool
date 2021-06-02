package com.zrtg.mittoolcore.service.impl;

import com.dtflys.forest.config.ForestConfiguration;
import com.zrtg.mittoolcore.client.SobeySolarClient;
import com.zrtg.mittoolcore.model.sobey.solar.Channel;
import com.zrtg.mittoolcore.service.SobeySolarService;

import java.util.List;


public class SobeySolarServiceImpl implements SobeySolarService {

    private ForestConfiguration forestConfiguration;

    public SobeySolarServiceImpl(ForestConfiguration forestConfiguration) {
        this.forestConfiguration = forestConfiguration;
    }

    @Override
    public List<Channel> getSolarColumn(String token) {
        SobeySolarClient sobeySolarClient = forestConfiguration.createInstance(SobeySolarClient.class);
        return sobeySolarClient.getSolarColumn(token);
    }




}
