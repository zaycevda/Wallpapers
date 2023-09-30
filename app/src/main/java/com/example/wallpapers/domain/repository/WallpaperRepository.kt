package com.example.wallpapers.domain.repository

interface WallpaperRepository {
    suspend fun setHomeScreenWallpaper(url: String)
    suspend fun setLockScreenWallpaper(url: String)
}