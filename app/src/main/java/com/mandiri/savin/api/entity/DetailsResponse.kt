package com.mandiri.savin.api.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsResponse(
    val date: String,
    val title: String,
    val balance: String,
    val transaction: String
) : Parcelable
