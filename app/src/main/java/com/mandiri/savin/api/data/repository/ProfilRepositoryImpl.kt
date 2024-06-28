package com.mandiri.savin.api.data.repository

import com.mandiri.savin.api.data.service.ProfilRemoteDataSource
import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response
import javax.inject.Inject

class ProfilRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProfilRemoteDataSource
) : ProfilRepository {

    override suspend fun getProfil(): Response<ProfilResponse> {
        return remoteDataSource.getProfil()
    }
}