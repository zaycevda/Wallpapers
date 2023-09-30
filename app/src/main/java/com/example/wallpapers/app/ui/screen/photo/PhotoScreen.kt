package com.example.wallpapers.app.ui.screen.photo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.wallpapers.app.ui.viewmodel.PhotoViewModel

@Composable
fun PhotoScreen(id: String) {
    val viewModel = hiltViewModel<PhotoViewModel>()
    val photo = viewModel.photo.collectAsState().value

    LaunchedEffect(key1 = Unit) { viewModel.getPhoto(id = id) }

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = photo.url,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
            Button(
                onClick = {
                    viewModel.setHomeScreenWallpaper(url = photo.url)
                }) {
                Text(text = "home screen")
            }
            Button(
                onClick = {
                    viewModel.setLockScreenWallpaper(url = photo.url)
                }) {
                Text(text = "lock screen")
            }
            Button(
                onClick = {
                    viewModel.setHomeScreenWallpaper(url = photo.url)
                    viewModel.setLockScreenWallpaper(url = photo.url)
                }) {
                Text(text = "both screens")
            }
        }
    }
}