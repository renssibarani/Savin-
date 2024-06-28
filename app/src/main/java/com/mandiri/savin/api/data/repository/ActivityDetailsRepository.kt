package com.mandiri.savin.api.data.repository

import com.mandiri.savin.model.HistoryDetailsResponse
import retrofit2.Response

interface ActivityDetailsRepository {

    suspend fun getActivityDetails(path: String) : Response<List<HistoryDetailsResponse>>
}