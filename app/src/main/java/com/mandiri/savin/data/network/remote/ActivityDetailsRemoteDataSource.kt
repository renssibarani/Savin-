package com.mandiri.savin.data.network.remote

import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

interface ActivityDetailsRemoteDataSource {

    suspend fun getActivityDetails(path: String): Response<List<ActivityDetailsResponse>>
}