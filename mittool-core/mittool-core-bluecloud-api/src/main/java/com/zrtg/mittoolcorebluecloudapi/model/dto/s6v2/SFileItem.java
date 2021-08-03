package com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2;

import lombok.Data;

@Data
public class SFileItem {
    // 文件的唯一标识（32位的guid）
    private String fileGUID;

    private SFileName fileName;

    private Long fileSize;

}
