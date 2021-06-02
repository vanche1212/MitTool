package com.zrtg.mittoolcore.model.entity;


import lombok.Data;

@Data
public class SContentInfo {
    // 素材的唯一标识（32位的guid）
    private String contentID;
    // 必填：素材类型（video 视音频、audio音频、picture 图片、document文档、hypermedia图文稿、script文稿通稿、rundown串联单、other其它）
    private String typeID;

    private SContentData contentData;



}
