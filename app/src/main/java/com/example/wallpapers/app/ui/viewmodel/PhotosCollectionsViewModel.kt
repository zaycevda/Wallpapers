package com.example.wallpapers.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.domain.model.PhotosCollection
import com.example.wallpapers.domain.usecase.GetPhotosCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosCollectionsViewModel @Inject constructor(
    private val useCase: GetPhotosCollectionsUseCase
) : ViewModel() {
    private val _collections = MutableStateFlow(value = listOf<PhotosCollection>())
    val collections = _collections.asStateFlow()

    fun getPhotosCollections() {
        viewModelScope.launch {
            _collections.value = useCase.execute()
        }
    }
}