package com.example.wallpapers.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.repository.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val repository: PhotosRepository
) : ViewModel() {
    private val _photos = MutableStateFlow(value = listOf<Photo>())
    val photos = _photos.asStateFlow()

    fun getPhotos(id: String) {
        viewModelScope.launch {
            _photos.value = repository.getPhotos(id = id)
        }
    }
}