package com.mandiri.savin.data.network.repository

import com.mandiri.savin.data.network.remote.ActivityDetailsRemoteDataSource
import com.mandiri.savin.data.network.remote.ActivityRemoteDataSource
import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

class ActivityDetailsRepositoryImpl(
    private val remoteDataSource: ActivityDetailsRemoteDataSource
):ActivityDetailsRepository {

    override suspend fun getActivityDetails(path: String): Response<List<ActivityDetailsResponse>> {
        return remoteDataSource.getActivityDetails(path)
    }
}