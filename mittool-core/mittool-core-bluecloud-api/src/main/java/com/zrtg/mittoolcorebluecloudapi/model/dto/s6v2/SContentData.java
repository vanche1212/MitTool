package com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2;

import lombok.Data;

import java.util.List;

@Data
public class SContentData {

    private SContentFile contentFile;
    private List<SEntityData> entityData;

}
