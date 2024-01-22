package com.mandiri.savin.data.network.usecase

import com.mandiri.savin.data.network.repository.ProfilRepository
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
