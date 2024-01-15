package com.mandiri.savin.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.savin.data.sharedPref.usecase.SetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val setTokenUseCase: SetTokenUseCase
) : ViewModel() {
    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: LiveData<Boolean> = _isLogin

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun checkLoginPassword(inPassword: String) {
        val password = "12345"

        fun checkLoginPIN(inPin: String) {
            val pin = "123456" // Harusnya diambil dari sumber yang aman, misalnya database

            inPin.let {
                if (it.isEmpty()) {
                    _isLogin.postValue(false)
                    _errorMessage.postValue("PIN Kosong")
                    return
                }
                if (inPin == pin) {
                    login()
                    _isLogin.postValue(true)
                    _errorMessage.postValue("")
                    return
                }
                _isLogin.postValue(false)
                _errorMessage.postValue("PIN Salah")
            }
        }

    }

    private fun login() {
        val dummyToken = UUID.randomUUID().toString()
        setTokenUseCase.setToken(dummyToken)
    }
}