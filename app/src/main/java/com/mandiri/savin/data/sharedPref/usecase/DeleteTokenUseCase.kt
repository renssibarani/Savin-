package com.mandiri.savin.data.sharedPref.usecase

import com.mandiri.savin.data.sharedPref.repository.UserRepository
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private var repository: UserRepository
) {
    fun deleteToken() {
        repository.deleteToken()
    }
}