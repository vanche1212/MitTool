package com.zrtg.mittoolcorebluecloudapi.model.dto.fp;

import lombok.Data;

@Data
public class PermissionLevel {
    private Boolean canDelete;
    private Boolean canExecute;
    private Boolean canRead;
    private Boolean canWrite;
    private Integer level;
    private String templateCode;
    private String templateName;
}
