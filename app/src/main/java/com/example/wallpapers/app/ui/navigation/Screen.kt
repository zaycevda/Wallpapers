package com.example.wallpapers.app.ui.navigation

sealed class Screen(val route: String) {
    object CollectionsScreen : Screen(route = "collections_screen")
    object PhotosScreen : Screen(route = "photos_screen")
    object PhotoScreen : Screen(route = "photo_screen")

    fun withArgs(vararg args: String) =
        buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
}