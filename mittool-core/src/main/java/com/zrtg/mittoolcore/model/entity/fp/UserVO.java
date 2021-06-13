package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

import java.util.List;


@Data
public class UserVO {
    private List<String> accessRestUriCodes;
    private String avatarUrl;
    private String createTime;
    private Integer deleted;
    private Integer disabled;
    private String disabledTime;
    private String email;
    private Integer failedCount;
    private List<GroupLevelVO> groups;
    private Integer id;
    private String link;
    private String loginName;
    private String nickName;
    private String oldPassword;
    private Integer operate;
    private List<OrganizationVO> organizations;
    private Integer parentId;
    private String password;
    private List<PermissionLevelVO> permissions;
    private String phone;
    private String pwdChangeTime;
    private String refreshToken;
    private Integer refreshTokenExpireTime;
    private List<RoleVO> roles;
    private String s3accesskeyId;
    private String s3secretkey;
    private String siteCode;
    private String siteName;
    private Integer siteType;
    private Long storageObjectCount;
    private Long storageSize;
    private Long storageUsage;
    private Long storageWarningPCT;
    private List<PermissionTemplateVO> templates;
    private Integer type;
    private String userCode;
    private String userToken;
    private Integer userTokenExpireTime;
    private String userUncode;

}
