package com.mandiri.savin.data.network.repository

import com.mandiri.savin.data.network.remote.ActivityRemoteDataSource
import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

class ActivityRepositoryImpl(
    private val remoteDataSource: ActivityRemoteDataSource
):ActivityRepository {
    override suspend fun getActivity(): Response<List<ActivityResponse>> {
        return remoteDataSource.getActivity()
    }
}