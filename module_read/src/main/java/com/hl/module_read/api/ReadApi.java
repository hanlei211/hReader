package com.hl.module_read.api;

import com.hl.lib.common.http.Api;

/**
 * created by hl
 * on 2020/5/15
 */
public class ReadApi  extends Api {

    public static Service api(){
        return  Api.api(Service.class);
    }
}
