package com.mandiri.savin.api.sharedPref.usecase

import com.mandiri.savin.api.sharedPref.repository.UserRepository
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private var repository: UserRepository
) {

    fun deleteToken() { repository.deleteToken() }
}