package com.mandiri.savin.api.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityModel(
    val date: String,
    val title: String,
    val balance: String,
    val transaction: String
) : Parcelable
