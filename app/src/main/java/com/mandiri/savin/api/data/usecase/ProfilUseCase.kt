package com.mandiri.savin.api.data.usecase

import com.mandiri.savin.api.data.repository.ProfilRepository
import com.mandiri.savin.model.ProfilResponse
import javax.inject.Inject


class ProfilUseCase @Inject constructor(
    private val repository: ProfilRepository
) {
    suspend fun getProfil(): ProfilResponse? {
        val response = repository.getProfil()
        if (response.isSuccessful) {
            return response.body()
        } else {
            return null
        }
    }
}
