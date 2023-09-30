package com.example.wallpapers.app.di

import com.example.wallpapers.data.net.repository.PhotosRepositoryImpl
import com.example.wallpapers.data.wallpaper.repository.WallpaperRepositoryImpl
import com.example.wallpapers.domain.repository.PhotosRepository
import com.example.wallpapers.domain.repository.WallpaperRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
    @Binds
    abstract fun bindWallpaperRepository(wallpaperRepositoryImpl: WallpaperRepositoryImpl): WallpaperRepository
}