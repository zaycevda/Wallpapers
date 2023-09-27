package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.PhotosRepository

class GetPhotosUseCase(private val repository: PhotosRepository) {
    suspend fun execute(id: Long) = repository.getPhotos(id = id)
}