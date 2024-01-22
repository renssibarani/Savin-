package com.mandiri.savin.data.network.repository

import com.mandiri.savin.data.network.remote.ProfilRemoteDataSource
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