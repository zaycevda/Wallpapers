package com.example.wallpapers.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.usecase.GetPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val useCase: GetPhotoUseCase
) : ViewModel() {
    private val _photo = MutableStateFlow(value = Photo.empty())
    val photo = _photo.asStateFlow()

    fun getPhoto(id: String) {
        viewModelScope.launch {
            _photo.value = useCase.execute(id = id)
        }
    }
}