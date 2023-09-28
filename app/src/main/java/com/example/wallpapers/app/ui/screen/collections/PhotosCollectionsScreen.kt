package com.example.wallpapers.app.ui.screen.collections

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wallpapers.app.ui.viewmodel.PhotosCollectionsViewModel

@Composable
fun PhotosCollectionsScreen(navController: NavController) {
    val viewModel = hiltViewModel<PhotosCollectionsViewModel>()
    val photosCollections = viewModel.collections.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getPhotosCollections()
    }

    LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
        items(count = photosCollections.count()) { index ->
            PhotosCollectionItem(
                photosCollection = photosCollections[index],
                navController = navController,
            )
        }
    }
}