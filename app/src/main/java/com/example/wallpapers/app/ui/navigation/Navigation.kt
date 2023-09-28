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
        startDestination = Screen.CollectionsScreen.route
    ) {
        composable(route = Screen.CollectionsScreen.route) { _ ->
            PhotosCollectionsScreen(navController = navController)
        }
        composable(
            route = Screen.PhotosScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            PhotosScreen(
                navController = navController,
                id = entry.arguments?.getString("id") ?: throw Exception()
            )
        }
        composable(
            route = Screen.PhotoScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            PhotoScreen(id = entry.arguments?.getString("id") ?: throw Exception())
        }
    }
}