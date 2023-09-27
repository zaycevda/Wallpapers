package com.example.wallpapers.data.net.model

import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("urls")
    val url: UrlsModel
)