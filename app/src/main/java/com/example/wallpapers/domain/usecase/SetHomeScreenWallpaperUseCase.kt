package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.WallpaperRepository
import javax.inject.Inject

class SetHomeScreenWallpaperUseCase @Inject constructor(private val repository: WallpaperRepository) {
    suspend fun execute(url: String) {
        repository.setHomeScreenWallpaper(url = url)
    }
}