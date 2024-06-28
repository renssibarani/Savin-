package com.mandiri.savin.api.data.service

import com.mandiri.savin.api.data.remote.ServiceSavin
import com.mandiri.savin.model.HistoryDetailsResponse
import retrofit2.Response
import javax.inject.Inject

class ActivityDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceSavin
): ActivityDetailsRemoteDataSource {

    override suspend fun getActivityDetails(path: String): Response<List<HistoryDetailsResponse>> {
        return service.getActivityDetails(path)
    }
}