package com.example.wallpapers.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.usecase.GetPhotoUseCase
import com.example.wallpapers.domain.usecase.SetHomeScreenWallpaperUseCase
import com.example.wallpapers.domain.usecase.SetLockScreenWallpaperUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase,
    private val setHomeScreenWallpaperUseCase: SetHomeScreenWallpaperUseCase,
    private val setLockScreenWallpaperUseCase: SetLockScreenWallpaperUseCase
) : ViewModel() {
    private val _photo = MutableStateFlow(value = Photo.empty())
    val photo = _photo.asStateFlow()

    fun getPhoto(id: String) {
        viewModelScope.launch {
            _photo.value = getPhotoUseCase.execute(id = id)
        }
    }

    fun setHomeScreenWallpaper(url: String) {
        viewModelScope.launch {
            setHomeScreenWallpaperUseCase.execute(url = url)
        }
    }

    fun setLockScreenWallpaper(url: String) {
        viewModelScope.launch {
            setLockScreenWallpaperUseCase.execute(url = url)
        }
    }
}