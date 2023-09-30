package com.example.wallpapers.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wallpapers.app.ui.screen.collections.PhotosCollectionsScreen
import com.example.wallpapers.app.ui.screen.photo.PhotoScreen
import com.example.wallpapers.app.ui.screen.photos.PhotosScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.COLLECTIONS_SCREEN.route
    ) {
        composable(route = Screen.COLLECTIONS_SCREEN.route) { _ ->
            PhotosCollectionsScreen(navController = navController)
        }
        composable(
            route = Screen.PHOTOS_SCREEN.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            PhotosScreen(
                navController = navController,
                id = entry.arguments?.getString("id") ?: throw IllegalArgumentException()
            )
        }
        composable(
            route = Screen.PHOTO_SCREEN.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            PhotoScreen(id = entry.arguments?.getString("id") ?: throw IllegalArgumentException())
        }
    }
}