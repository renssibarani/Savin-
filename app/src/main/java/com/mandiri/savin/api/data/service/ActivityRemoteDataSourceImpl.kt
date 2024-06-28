package com.mandiri.savin.api.data.service

import com.mandiri.savin.api.data.remote.ServiceSavin
import com.mandiri.savin.model.ActivityResponse
import retrofit2.Response
import javax.inject.Inject

class ActivityRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceSavin
): ActivityRemoteDataSource {

    override suspend fun getActivity(): Response<List<ActivityResponse>> {
        return service.getActivity()
    }
}