package com.odinson.loki.mir_mosaic;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by ergas on 11/3/2017.
 */

public interface ServerAPI {
    @GET("getCategory")
    List<CategoryType> getCategory();
}
