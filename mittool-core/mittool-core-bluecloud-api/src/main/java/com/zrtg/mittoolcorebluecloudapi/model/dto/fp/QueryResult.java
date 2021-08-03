package com.zrtg.mittoolcorebluecloudapi.model.dto.fp;

import lombok.Data;

import java.util.List;

@Data
public class QueryResult {
    private Integer page;
    private Integer pageSize;
    private Integer size;
    private List<User> resultList;
}
