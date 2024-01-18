package com.mandiri.savin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EwalletModel(
    val title: String,
    val progres: Int,
    val message: String,
    val balance: String,
    val path: String

):Parcelable
