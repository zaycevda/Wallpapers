package com.example.wallpapers.app.ui.screen.photos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.wallpapers.app.ui.navigation.Screen
import com.example.wallpapers.domain.model.Photo

@Composable
fun PhotoItem(
    navController: NavController,
    photo: Photo,
) {
    AsyncImage(
        model = photo.url,
        contentDescription = photo.description,
        modifier = Modifier
            .padding(all = 6.dp)
            .height(height = 120.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screen.PHOTO_SCREEN.withArgs(photo.id))
            },
        contentScale = ContentScale.Crop
    )
}