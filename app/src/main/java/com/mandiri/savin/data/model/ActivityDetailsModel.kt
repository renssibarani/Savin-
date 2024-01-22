package com.mandiri.savin.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityDetailsModel(
    val date: String,
    val title: String,
    val balance: String,
    val transaction: String
) : Parcelable
