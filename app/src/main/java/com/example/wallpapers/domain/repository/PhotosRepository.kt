package com.example.wallpapers.domain.repository

import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.model.PhotosCollection

interface PhotosRepository {
    suspend fun getPhotosCollections(): List<PhotosCollection>
    suspend fun getPhotos(id: Long): List<Photo>
    suspend fun getPhoto(id: String): Photo
}