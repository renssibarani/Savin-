package com.mandiri.savin.api.data.repository

import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

interface ActivityRepository {

    suspend fun getActivity() : Response<List<ActivityResponse>>
}