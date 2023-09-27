package com.example.wallpapers.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.model.PhotosCollection
import com.example.wallpapers.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotosViewModel(private val repository: PhotosRepository) : ViewModel() {
    private val _collections = MutableStateFlow(value = listOf<PhotosCollection>())
    val collections = _collections.asStateFlow()

    private val _photos = MutableStateFlow(value = listOf<Photo>())
    val photos = _photos.asStateFlow()

    private val _photo = MutableStateFlow(value = Photo.empty())
    val photo = _photo.asStateFlow()

    fun getPhotosCollections() {
        viewModelScope.launch {
            _collections.value = repository.getPhotosCollections()
        }
    }

    fun getPhotos(id: Long) {
        viewModelScope.launch {
            _photos.value = repository.getPhotos(id = id)
        }
    }

    fun getPhoto(id: String) {
        viewModelScope.launch {
            _photo.value = repository.getPhoto(id = id)
        }
    }
}