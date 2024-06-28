package com.mandiri.savin.api.data.service

import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

interface ActivityRemoteDataSource {

    suspend fun getActivity(): Response<List<ActivityResponse>>
}