package com.zrtg.mittoolcore.model.sobey.solar;

import lombok.Data;

import java.util.List;


@Data
public class Column {
    private String id;
    private Integer uniqueId_;
    private String parentId;
    private String pathCode;
    private String namespace;
    private String name;
    private String description;
    private String privilege;
    private ColumnMetaData metadata;
    // 后面多余字段省略...
}
