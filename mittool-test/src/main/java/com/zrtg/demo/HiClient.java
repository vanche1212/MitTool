package com.zrtg.demo;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.GetRequest;
import com.dtflys.forest.annotation.Request;


public interface HiClient {

    @Request(
            url = "http://www.baidu.com",
            dataType = "json"
    )
    String sss();

}
