package com.mandiri.savin.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.savin.api.sharedPref.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashscreenViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

    fun checkLoginPref() : LiveData<Boolean> {
        val isLogin = MutableLiveData<Boolean>()
        val token = getTokenUseCase.getToken()

        if (token.isNotEmpty())
            isLogin.postValue(true)
        else
            isLogin.postValue(false)

        return isLogin
    }
}