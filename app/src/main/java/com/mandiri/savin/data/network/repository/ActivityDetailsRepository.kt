package com.mandiri.savin.data.network.repository

import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import java.util.SplittableRandom

interface ActivityDetailsRepository {
    suspend fun getActivityDetails(path: String) : Response<List<ActivityDetailsResponse>>
}