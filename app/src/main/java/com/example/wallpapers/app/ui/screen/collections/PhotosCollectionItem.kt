package com.example.wallpapers.app.ui.screen.collections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.wallpapers.app.ui.navigation.Screen
import com.example.wallpapers.domain.model.PhotosCollection

@Composable
fun PhotosCollectionItem(
    photosCollection: PhotosCollection,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(all = 6.dp)
            .height(height = 120.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screen.PhotosScreen.withArgs(photosCollection.id))
            }
    ) {
        AsyncImage(
            model = photosCollection.cover,
            contentDescription = photosCollection.description,
            contentScale = ContentScale.Crop
        )
        Text(
            text = photosCollection.title,
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(all = 6.dp),
            color = Color.White,
            fontSize = 16.sp
        )
    }
}