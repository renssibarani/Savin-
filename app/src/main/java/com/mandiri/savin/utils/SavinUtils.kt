package com.mandiri.savin.utils

import android.content.Context
import android.widget.Toast

object SavinUtils {

    fun Context.createToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun Int.formatProgress(): String {
        return "$this%"
    }

    fun String.formatEstimate(): String {
        return "Tersisa $this"
    }
}