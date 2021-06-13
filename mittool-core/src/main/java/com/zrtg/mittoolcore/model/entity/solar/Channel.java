package com.zrtg.mittoolcore.model.entity.solar;

import lombok.Data;

import java.util.List;

@Data
public class Channel {
    private String id;
    private Integer uniqueId_;
    private String pathCode;
    private String name;
    private String description;
    private String privilege;
    private List<Column> columns;
}
