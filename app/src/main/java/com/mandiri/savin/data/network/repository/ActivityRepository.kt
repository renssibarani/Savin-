package com.mandiri.savin.data.network.repository

import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import java.util.SplittableRandom

interface ActivityRepository {
    suspend fun getActivity() : Response<List<ActivityResponse>>
    suspend fun getActivityEwallet(path: String) : Response<List<ActivityResponse>>
}