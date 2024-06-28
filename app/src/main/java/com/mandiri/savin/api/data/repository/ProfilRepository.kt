package com.mandiri.savin.api.data.repository

import com.mandiri.savin.model.ProfilResponse
import retrofit2.Response

interface ProfilRepository {

    suspend fun getProfil() : Response<ProfilResponse>
}