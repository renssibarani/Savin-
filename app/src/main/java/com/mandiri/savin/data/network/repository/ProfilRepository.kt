package com.mandiri.savin.data.network.repository

import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response

interface ProfilRepository {
    suspend fun getProfil() : Response<ProfilResponse>
}