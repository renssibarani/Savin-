package com.mandiri.savin.data.network.remote

import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response

interface ProfilRemoteDataSource {
    suspend fun getProfil(): Response<ProfilResponse>
}