package com.mandiri.savin.api.data.repository

import com.mandiri.savin.api.data.service.ActivityDetailsRemoteDataSource
import com.mandiri.savin.model.HistoryDetailsResponse
import retrofit2.Response

class ActivityDetailsRepositoryImpl(
    private val remoteDataSource: ActivityDetailsRemoteDataSource
):ActivityDetailsRepository {

    override suspend fun getActivityDetails(path: String): Response<List<HistoryDetailsResponse>> {
        return remoteDataSource.getActivityDetails(path)
    }
}