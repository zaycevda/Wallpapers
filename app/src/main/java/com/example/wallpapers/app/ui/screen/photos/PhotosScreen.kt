package com.example.wallpapers.app.ui.screen.photos

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wallpapers.app.ui.viewmodel.PhotosViewModel

@Composable
fun PhotosScreen(
    navController: NavController,
    id: String
) {
    val viewModel = hiltViewModel<PhotosViewModel>()
    val photos = viewModel.photos.collectAsState().value

    LaunchedEffect(key1 = Unit) { viewModel.getPhotos(id = id) }

    LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
        items(count = photos.count()) { index ->
            PhotoItem(
                navController = navController,
                photo = photos[index]
            )
        }
    }
}