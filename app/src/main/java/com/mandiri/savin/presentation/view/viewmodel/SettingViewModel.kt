package com.mandiri.savin.presentation.view.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.savin.LoginActivity
import com.mandiri.savin.data.sharedPref.usecase.DeleteTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val deleteTokenUseCase: DeleteTokenUseCase
) : ViewModel() {
    private val _logout = MutableLiveData<Unit>()
    val logout: LiveData<Unit>
        get() = _logout

    fun logout() {
        deleteTokenUseCase.deleteToken()
        _logout.value = Unit
    }
}