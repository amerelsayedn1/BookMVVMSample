package com.alpha.bookapplication.data.model

import com.google.gson.annotations.SerializedName


data class BaseModel<T>(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    var data: T?
)