package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

@Data
public class GroupLevelVO {
    private Boolean canDelete;
    private Boolean canExecute;
    private Boolean canRead;
    private Boolean canWrite;
    private String groupCode;
    private String groupName;
    private Integer level;
}
