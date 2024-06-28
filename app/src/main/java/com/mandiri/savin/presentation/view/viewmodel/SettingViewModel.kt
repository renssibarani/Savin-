package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.savin.api.sharedPref.SharedPref
import com.mandiri.savin.api.sharedPref.usecase.DeleteTokenUseCase
import com.mandiri.savin.model.ProfilResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val sharedPref: SharedPref,
    private val deleteTokenUseCase: DeleteTokenUseCase
) : ViewModel() {

    private val _profilData = MutableLiveData<ProfilResponse?>()
    private val _logout = MutableLiveData<Unit>()

    val profilData: MutableLiveData<ProfilResponse?> = _profilData
    val logout: LiveData<Unit>
        get() = _logout


    init {
        loadProfilData()
    }

    private fun loadProfilData() {
        sharedPref.getProfileData()?.let {
            _profilData.postValue(it)
        }
    }

    fun logout() {
        deleteTokenUseCase.deleteToken()
        _logout.value = Unit
    }
}