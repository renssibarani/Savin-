package com.mandiri.savin.api.data.service

import com.mandiri.savin.api.data.remote.ServiceSavin
import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response
import javax.inject.Inject

class ProfilRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceSavin
) : ProfilRemoteDataSource {

    override suspend fun getProfil(): Response<ProfilResponse> {
        return service.getProfil()
    }
}