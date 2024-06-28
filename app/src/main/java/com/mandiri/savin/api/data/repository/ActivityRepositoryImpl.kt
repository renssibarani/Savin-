package com.mandiri.savin.api.data.repository

import com.mandiri.savin.api.data.service.ActivityRemoteDataSource
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response

class ActivityRepositoryImpl(
    private val remoteDataSource: ActivityRemoteDataSource
):ActivityRepository {

    override suspend fun getActivity(): Response<List<ActivityResponse>> {
        return remoteDataSource.getActivity()
    }
}