package com.zrtg.mittoolcore.model.entity;

import lombok.Data;

@Data
public class SFileItem {
    // 文件的唯一标识（32位的guid）
    private String fileGUID;

    private SFileName fileName;

}
