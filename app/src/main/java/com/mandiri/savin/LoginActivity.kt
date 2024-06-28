package com.mandiri.savin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.mandiri.savin.databinding.ActivityLoginBinding
import com.mandiri.savin.presentation.view.viewmodel.LoginViewModel
import com.mandiri.savin.utils.SavinUtils.createToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNumberPad()
        handleLogin()
        observeViewModel()
        if (viewModel.isUserLoggedIn()) {
            handleTo(HomeMainActivity::class.java)
        }
    }

    private fun observeViewModel() {
        viewModel.isLogin.observe(this) {
            if (it) {
                handleVisibility(binding.componentNumpad.tvError, false)
                createToast("Berhasil Login")
                navigateToHome()
            }
        }

        viewModel.errorMessage.observe(this) {
            if (it.isNotEmpty()) {
                handleVisibility(binding.componentNumpad.tvError, true)
                createToast(it)
            }
        }
    }

    private fun handleVisibility(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }

    private fun setupNumberPad() {
        binding.componentNumpad.btn0.setOnClickListener{
            numberClicked("0")
        }
        binding.componentNumpad.btn1.setOnClickListener{
            numberClicked("1")
        }
        binding.componentNumpad.btn2.setOnClickListener{
            numberClicked("2")
        }
        binding.componentNumpad.btn3.setOnClickListener{
            numberClicked("3")
        }
        binding.componentNumpad.btn4.setOnClickListener{
            numberClicked("4")
        }
        binding.componentNumpad.btn5.setOnClickListener{
            numberClicked("5")
        }
        binding.componentNumpad.btn6.setOnClickListener{
            numberClicked("6")
        }
        binding.componentNumpad.btn7.setOnClickListener{
            numberClicked("7")
        }
        binding.componentNumpad.btn8.setOnClickListener{
            numberClicked("8")
        }
        binding.componentNumpad.btn9.setOnClickListener{
            numberClicked("9")
        }
        binding.componentNumpad.btnDelete.setOnClickListener{
            deleteNumber()
        }
    }

    private fun numberClicked(number: String) {
        val currentText = binding.componentNumpad.etPIN.text.toString()
        if (currentText.length < 6) {
            binding.componentNumpad.etPIN.append(number)
        }
    }

    private fun deleteNumber() {
        val currentText = binding.componentNumpad.etPIN.text.toString()
        if (currentText.isNotEmpty()) {
            binding.componentNumpad.etPIN.setText(currentText.substring(0, currentText.length - 1))
        }
    }

    private fun handleLogin() {
        binding.componentNumpad.etPIN.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val value = s.toString()
                if (value.length == 6) {
                    binding.componentNumpad.etPIN.removeTextChangedListener(this)
                    viewModel.checkLoginPassword(value)
                    binding.componentNumpad.etPIN.addTextChangedListener(this)
                }
            }
        })
    }

    private fun navigateToHome() {
        val intent = Intent(this@LoginActivity, HomeMainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleTo(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}