package com.mandiri.savin.data.sharedPref.usecase

import com.mandiri.savin.data.sharedPref.repository.UserRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: UserRepository
) {
    fun getToken() = repository.getToken()

}