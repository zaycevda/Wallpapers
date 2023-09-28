package com.example.wallpapers.data.net.model

import com.google.gson.annotations.SerializedName

data class PhotosCollectionModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("total_photos")
    val totalPhotos: Int,
    @SerializedName("cover_photo")
    val cover: PhotoModel
)