package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.PhotosRepository

class GetPhotosCollectionsUseCase(private val repository: PhotosRepository) {
    suspend fun execute() = repository.getPhotosCollections()
}