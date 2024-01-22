package com.mandiri.savin.data.network.remote

import com.mandiri.savin.data.ServiceSavin
import com.mandiri.savin.model.ActivityDetailsResponse
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import javax.inject.Inject

class ActivityDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceSavin
): ActivityDetailsRemoteDataSource {
    override suspend fun getActivityDetails(path: String): Response<List<ActivityDetailsResponse>> {
        return service.getActivityDetails(path)
    }

}