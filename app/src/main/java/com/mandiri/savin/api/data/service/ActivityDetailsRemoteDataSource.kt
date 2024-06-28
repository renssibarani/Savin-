package com.mandiri.savin.api.data.service

import com.mandiri.savin.model.HistoryDetailsResponse
import retrofit2.Response

interface ActivityDetailsRemoteDataSource {

    suspend fun getActivityDetails(path: String): Response<List<HistoryDetailsResponse>>
}