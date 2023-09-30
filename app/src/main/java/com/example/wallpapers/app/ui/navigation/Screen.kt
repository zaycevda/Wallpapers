package com.example.wallpapers.app.ui.navigation

enum class Screen(val route: String) {
    COLLECTIONS_SCREEN(route = "collections_screen"),
    PHOTOS_SCREEN(route = "photos_screen"),
    PHOTO_SCREEN(route = "photo_screen");

    fun withArgs(vararg args: String) =
        buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
}