package com.example.wallpapers.app.ui.screen.photo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.wallpapers.app.ui.viewmodel.PhotosViewModel

@Composable
fun PhotoScreen(id: String) {
    val viewModel = hiltViewModel<PhotosViewModel>()
    val photo = viewModel.photo.collectAsState().value

    LaunchedEffect(key1 = Unit) { viewModel.getPhoto(id = id) }

    AsyncImage(
        model = photo.url,
        contentDescription = photo.description,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}