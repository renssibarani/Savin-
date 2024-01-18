package com.mandiri.savin.presentation.view.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.savin.data.sharedPref.SharedPref
import com.mandiri.savin.data.sharedPref.local.LocalDataSource
import com.mandiri.savin.data.sharedPref.usecase.GetTokenUseCase
import com.mandiri.savin.data.sharedPref.usecase.SetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val setTokenUseCase: SetTokenUseCase,
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> = _isLogin

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    @SuppressLint("SuspiciousIndentation")
    fun checkLoginPassword(inPin: String) {
        val password = "123456"

            inPin.let {
                if (it.isEmpty()) {
                    _isLogin.postValue(false)
                    _errorMessage.postValue("PIN Kosong")
                    return
                }
                if (inPin == password) {
                    login()
                    _isLogin.postValue(true)
                    return
                }
                _isLogin.postValue(false)
                _errorMessage.postValue("PIN Salah")
            }
        }



    private fun login() {
        val dummyToken = UUID.randomUUID().toString()
        setTokenUseCase.setToken(dummyToken)
    }
    fun isUserLoggedIn(): Boolean {
        val token = getTokenUseCase.getToken()
        return token.isNotEmpty()
    }
}