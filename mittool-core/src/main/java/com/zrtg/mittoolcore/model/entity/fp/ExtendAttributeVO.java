package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

@Data
public class ExtendAttributeVO {
    private String attributeGroup;
    private String attributeKey;
    private String attributeValue;
    private Integer copyFrom;
    private String createTime;
    private String creatorCode;
    private String description;
    private Integer id;
    private String sourceCode;
    private Integer sourceId;
}
