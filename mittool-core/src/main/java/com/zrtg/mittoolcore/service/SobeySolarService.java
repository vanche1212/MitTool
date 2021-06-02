package com.zrtg.mittoolcore.service;

import com.zrtg.mittoolcore.model.sobey.solar.Channel;

import java.util.List;

public interface SobeySolarService {

    List<Channel> getSolarColumn(String token);

}
