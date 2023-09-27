package com.example.wallpapers.domain.model

data class Photo(
    val id: String,
    val url: String
) {
    companion object {
        fun empty() =
            Photo(
                id = "",
                url = ""
            )
    }
}