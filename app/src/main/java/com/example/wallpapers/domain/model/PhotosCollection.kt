package com.example.wallpapers.domain.model

data class PhotosCollection(
    val id: String,
    val title: String,
    val description: String?,
    val totalPhotos: Int,
    val cover: String?
)