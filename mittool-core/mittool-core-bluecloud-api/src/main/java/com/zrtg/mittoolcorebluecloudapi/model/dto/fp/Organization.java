package com.zrtg.mittoolcorebluecloudapi.model.dto.fp;

import lombok.Data;

import java.util.List;

@Data
public class Organization {
    private String description;
    private List<ExtendAttribute> extendAttributes;
    private String externalCode;
    private Integer id;
    private String oldOrganizationName;
    private Integer operate;
    private String organizationCode;
    private String organizationName;
    private Integer parentId;
    private Organization parentOrganization;
    private String parentPath;
    private String siteCode;
    private String siteName;
}
