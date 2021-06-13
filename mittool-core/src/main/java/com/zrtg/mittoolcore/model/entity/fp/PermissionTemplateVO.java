package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

@Data
public class PermissionTemplateVO {
    private String createTime;
    private Integer deleted;
    private Integer id;
    private String ownerCode;
    private String siteCode;
    private String siteName;
    private String templateCode;
    private String templateName;
    private Integer templateType;
    private String updateTime;
}
