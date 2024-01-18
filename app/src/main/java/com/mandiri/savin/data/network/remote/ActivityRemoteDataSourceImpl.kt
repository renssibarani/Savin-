package com.mandiri.savin.data.network.remote

import com.mandiri.savin.data.ServiceSavin
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import javax.inject.Inject

class ActivityRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceSavin
): ActivityRemoteDataSource {
    override suspend fun getActivity(): Response<List<ActivityResponse>> {
        return service.getActivity()
    }

    override suspend fun getActivityEwallet(path: String): Response<List<ActivityResponse>> {
        return service.getActivityEwallet(path)
    }

}