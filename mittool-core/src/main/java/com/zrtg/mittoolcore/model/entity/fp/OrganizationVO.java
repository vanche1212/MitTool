package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationVO {
    private String description;
    private List<ExtendAttributeVO> extendAttributes;
    private String externalCode;
    private Integer id;
    private String oldOrganizationName;
    private Integer operate;
    private String organizationCode;
    private String organizationName;
    private Integer parentId;
    private OrganizationVO parentOrganization;
    private String parentPath;
    private String siteCode;
    private String siteName;
}
