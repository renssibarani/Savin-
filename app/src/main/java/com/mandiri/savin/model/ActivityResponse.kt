package com.mandiri.savin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActivityResponse(
    @field:SerializedName("date")
    val date: String = "",

    @field:SerializedName("title")
    val title: String = "",

    @field:SerializedName("balance")
    val balance: String = "",

    @field:SerializedName("transaction")
    val transaction: String = "",
):Parcelable
