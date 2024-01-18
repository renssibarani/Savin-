package com.mandiri.savin.presentation.view.bottomsheet

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mandiri.savin.databinding.BottomSheetAuthBinding

class AuthBottomSheet(
    private val context: Context,
    private val onConfirmAction: (String) -> Unit
) {
    private lateinit var binding: BottomSheetAuthBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog

    fun show() {
        binding = BottomSheetAuthBinding.inflate(LayoutInflater.from(context))
        bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(binding.root)
        setupNumberPad()
        handleAuthPin()
        binding.componentToolbarAuth.ivBack.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
        binding.componentToolbarAuth.tvToolbarTitle.text = "Autentikasi"
        bottomSheetDialog.show()
    }

    private fun setupNumberPad() {
        binding.componentNumpad.btn0.setOnClickListener {
            numberClicked("0")
        }
        binding.componentNumpad.btn1.setOnClickListener {
            numberClicked("1")
        }
        binding.componentNumpad.btn2.setOnClickListener {
            numberClicked("2")
        }
        binding.componentNumpad.btn3.setOnClickListener {
            numberClicked("3")
        }
        binding.componentNumpad.btn4.setOnClickListener {
            numberClicked("4")
        }
        binding.componentNumpad.btn5.setOnClickListener {
            numberClicked("5")
        }
        binding.componentNumpad.btn6.setOnClickListener {
            numberClicked("6")
        }
        binding.componentNumpad.btn7.setOnClickListener {
            numberClicked("7")
        }
        binding.componentNumpad.btn8.setOnClickListener {
            numberClicked("8")
        }
        binding.componentNumpad.btn9.setOnClickListener {
            numberClicked("9")
        }
        binding.componentNumpad.btnDelete.setOnClickListener {
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

    private fun handleAuthPin() {
        binding.componentNumpad.etPIN.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val value = s.toString()
                if (value.length == 6) {
                    if (value == CORRECT_PIN) {
                        onConfirmAction(value)
                        bottomSheetDialog.dismiss()
                        binding.componentNumpad.etPIN.removeTextChangedListener(this)
                    } else {
                        binding.componentNumpad.tvError.visibility = View.VISIBLE
                        binding.componentNumpad.etPIN.text.clear()
                    }
                    binding.componentNumpad.etPIN.addTextChangedListener(this)
                }
            }
        })
    }

    companion object {
        const val CORRECT_PIN = "123456"
    }
}