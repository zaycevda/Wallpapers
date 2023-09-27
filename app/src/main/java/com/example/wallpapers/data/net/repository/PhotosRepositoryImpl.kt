package com.example.wallpapers.data.net.repository

import com.example.wallpapers.data.net.service.PhotosApi
import com.example.wallpapers.data.net.util.toPhoto
import com.example.wallpapers.data.net.util.toPhotosCollection
import com.example.wallpapers.domain.repository.PhotosRepository

class PhotosRepositoryImpl(private val api: PhotosApi) : PhotosRepository {
    override suspend fun getPhotosCollections() = api.getPhotosCollections().map { it.toPhotosCollection() }
    override suspend fun getPhotos(id: Long) = api.getPhotos(id = id).map { it.toPhoto() }
    override suspend fun getPhoto(id: String) = api.getPhoto(id = id).toPhoto()
}