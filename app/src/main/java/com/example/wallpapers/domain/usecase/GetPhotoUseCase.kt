package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.PhotosRepository

class GetPhotoUseCase(private val repository: PhotosRepository) {
    suspend fun execute(id: String) = repository.getPhoto(id = id)
}