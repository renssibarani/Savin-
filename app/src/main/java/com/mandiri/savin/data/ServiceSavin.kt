package com.mandiri.savin.data

import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceSavin {
    @GET("/activity")
    suspend fun getActivity():Response<List<ActivityResponse>>

    @GET("/{path}")
    suspend fun getActivityEwallet(
        @Path("path") path: String
    ):Response<List<ActivityResponse>>

}