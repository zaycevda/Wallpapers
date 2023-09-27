package com.example.wallpapers.data.net.model

import com.google.gson.annotations.SerializedName

data class PhotosCollectionModel(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("cover_photo")
    val cover: PhotoModel
)