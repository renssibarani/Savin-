package com.mandiri.savin.api.data.remote

import com.mandiri.savin.model.HistoryDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceSavin {

    @GET("/activity")
    suspend fun getActivity():Response<List<ActivityResponse>>

    @GET("/{path}")
    suspend fun getActivityDetails(
        @Path("path") path: String
    ):Response<List<HistoryDetailsResponse>>

    @GET("/profil")
    suspend fun getProfil():Response<ProfilResponse>

}