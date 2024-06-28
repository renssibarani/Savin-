package com.mandiri.savin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfilResponse(
    @field:SerializedName("name")
    val name: String = "",

    @field:SerializedName("email")
    val email: String = "",

    @field:SerializedName("phone_number")
    val phoneNumber: String = "",

    @field:SerializedName("image_url")
    val imageUrl: String = "",
) : Parcelable
