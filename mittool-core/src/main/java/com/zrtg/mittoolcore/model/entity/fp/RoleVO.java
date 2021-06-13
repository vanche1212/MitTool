package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

@Data
public class RoleVO {
    private Integer count;
    private String createTime;
    private String description;
    private Integer disabled;
    private Integer id;
    private Integer parentId;
    private Integer privilegeAdmin;
    private String roleCode;
    private String roleName;
    private Integer roleType;
    private String siteCode;
    private String siteName;
    private String updateTime;

}
