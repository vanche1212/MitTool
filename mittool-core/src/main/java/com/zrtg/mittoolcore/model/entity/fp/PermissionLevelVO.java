package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

@Data
public class PermissionLevelVO {
    private Boolean canDelete;
    private Boolean canExecute;
    private Boolean canRead;
    private Boolean canWrite;
    private Integer level;
    private String templateCode;
    private String templateName;
}
