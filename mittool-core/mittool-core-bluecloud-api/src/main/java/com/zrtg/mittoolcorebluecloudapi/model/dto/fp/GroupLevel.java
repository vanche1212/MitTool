package com.zrtg.mittoolcorebluecloudapi.model.dto.fp;

import lombok.Data;

@Data
public class GroupLevel {
    private Boolean canDelete;
    private Boolean canExecute;
    private Boolean canRead;
    private Boolean canWrite;
    private String groupCode;
    private String groupName;
    private Integer level;
}
