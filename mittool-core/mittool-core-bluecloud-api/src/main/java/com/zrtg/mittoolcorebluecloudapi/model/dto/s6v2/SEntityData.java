package com.zrtg.mittoolcorebluecloudapi.model.dto.s6v2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SEntityData {

    private String itemCode;
    private String attributeItem;
    private String value;
    private String itemName;
    private String itemID;

}
