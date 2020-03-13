package com.alpha.bookapplication.data.networking.baseRequest

import com.google.gson.annotations.SerializedName

data class ErrorBodyModel(
    @SerializedName("state")
    val state: Boolean = true,
    @SerializedName("msg")
    val message: String = ""
)