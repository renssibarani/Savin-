package com.mandiri.savin.api.data.service

import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response

interface ProfilRemoteDataSource {

    suspend fun getProfil(): Response<ProfilResponse>
}