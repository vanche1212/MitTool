package com.zrtg.mittoolcore.model.entity.fp;

import lombok.Data;

import java.util.List;

@Data
public class QueryResultVO {
    private Integer page;
    private Integer pageSize;
    private Integer size;
    private List<UserVO> resultList;
}
