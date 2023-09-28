package com.example.wallpapers.domain.model

data class Photo(
    val id: String,
    val description: String?,
    val url: String
) {
    companion object {
        fun empty() =
            Photo(
                id = "",
                description = null,
                url = ""
            )
    }
}