package com.mandiri.savin.api.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EwalletResponse(
    val title: String,
    val progres: Int,
    val message: String,
    val balance: String,
    val path: String
):Parcelable
