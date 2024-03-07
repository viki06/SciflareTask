package com.example.sciflaretask.model

import com.google.gson.annotations.SerializedName


object Model {

    data class User(
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String,
        @SerializedName("mobile") val mobile: String,
        @SerializedName("gender") val gender: String,
        @SerializedName("_id") val id: String
    )

}
