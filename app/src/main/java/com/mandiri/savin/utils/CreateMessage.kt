package com.mandiri.savin.utils

import android.content.Context
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

object CreateMessage {
    fun Context.createToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}