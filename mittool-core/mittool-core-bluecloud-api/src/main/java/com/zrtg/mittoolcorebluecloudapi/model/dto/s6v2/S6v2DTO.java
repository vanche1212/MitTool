package com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2;

import cn.hutool.core.lang.UUID;
import lombok.Data;

@Data
public class S6v2DTO {

    private String guid = UUID.randomUUID().toString();

    private String taskName;

    private String typeId = "Clip";
    private String typeName = "素材";

    private String fullPath;
    private Long fileSize;

    private String entityTypeValue = "biz_sobey_video";
    private String author;
    private String clipName;

}
