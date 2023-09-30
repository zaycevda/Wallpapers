package com.example.wallpapers.domain.usecase

import com.example.wallpapers.domain.repository.WallpaperRepository
import javax.inject.Inject

class SetLockScreenWallpaperUseCase @Inject constructor(private val repository: WallpaperRepository) {
    suspend fun execute(url: String) {
        repository.setLockScreenWallpaper(url = url)
    }
}