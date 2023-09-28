package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.PhotosRepository
import javax.inject.Inject

class GetPhotosCollectionsUseCase @Inject constructor(private val photosRepository: PhotosRepository) {
    suspend fun execute() = photosRepository.getPhotosCollections()
}