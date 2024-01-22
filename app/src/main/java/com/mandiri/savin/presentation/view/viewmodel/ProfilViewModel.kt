package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.savin.data.model.ActivityModel
import com.mandiri.savin.data.network.remote.ProfilRemoteDataSourceImpl
import com.mandiri.savin.data.network.usecase.ProfilUseCase
import com.mandiri.savin.data.sharedPref.SharedPref
import com.mandiri.savin.model.ProfilResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfilViewModel @Inject constructor(
    private val profilUseCase: ProfilUseCase,
    private val sharedPref: SharedPref
) : ViewModel() {
    private val _profilData = MutableLiveData<ProfilResponse>()
    val profilData: LiveData<ProfilResponse>
        get() = _profilData

    private val _isLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _isLoading

    init {
        _isLoading.postValue(true)
    }

    fun setProfilData() = viewModelScope.launch {
        profilUseCase.getProfil().apply {
            _isLoading.postValue(false)
            _profilData.postValue(this)
        }
    }

    fun fetchAndSaveProfile() = viewModelScope.launch {
        val profileResponse = profilUseCase.getProfil()
        profileResponse?.let {
            sharedPref.saveProfileData(it)
        }
    }

}