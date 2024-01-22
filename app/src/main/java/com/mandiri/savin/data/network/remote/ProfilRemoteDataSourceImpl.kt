package com.mandiri.savin.data.network.remote

import com.mandiri.savin.data.ServiceSavin
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