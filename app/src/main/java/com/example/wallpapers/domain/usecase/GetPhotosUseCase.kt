package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.PhotosRepository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private val photosRepository: PhotosRepository) {
    suspend fun execute(id: String) = photosRepository.getPhotos(id = id)
}