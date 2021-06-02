package com.zrtg.mittoolcore.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class SContentData {

    private SContentFile contentFile;
    private List<SEntityData> entityData;

}
