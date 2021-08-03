package com.zrtg.mittoolcorelog.log;

import lombok.Data;

import java.util.List;

@Data
public class MtRequest {
    // 请求路径
    private String requestUrl;
    // 请求方法
    private String requestMethod;
    // 请求参数
    private List<MtParam> requestParams;
    // 请求IP
    private String requestIp;
    // 请求类
    private String requestClass;
    // 请求数据
    private String requestData;
    // 返回结果
    private String responseResult;
    // 响应时间
    private String responseTime;


}
