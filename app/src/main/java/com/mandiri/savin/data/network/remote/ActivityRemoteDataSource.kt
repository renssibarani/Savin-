package com.mandiri.savin.data.network.remote

import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

interface ActivityRemoteDataSource {

    suspend fun getActivity():Response<List<ActivityResponse>>

    suspend fun getActivityEwallet(path: String):Response<List<ActivityResponse>>
}