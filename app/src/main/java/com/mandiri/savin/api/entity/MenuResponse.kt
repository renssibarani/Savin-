package com.mandiri.savin.api.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuResponse(
    val image: Int,
    val menuTitle: String
):Parcelable
