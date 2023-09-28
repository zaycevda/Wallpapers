package com.example.wallpapers.app.di

import com.example.wallpapers.data.net.repository.PhotosRepositoryImpl
import com.example.wallpapers.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
}