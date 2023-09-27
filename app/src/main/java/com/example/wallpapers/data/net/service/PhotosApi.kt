package com.example.wallpapers.data.net.service

import com.example.wallpapers.data.net.model.PhotoModel
import com.example.wallpapers.data.net.model.PhotosCollectionModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PhotosApi {
    @Headers(ACCEPT_VERSION_V1, AUTHORIZATION)
    @GET("collections")
    suspend fun getPhotosCollections(): List<PhotosCollectionModel>
    @Headers(ACCEPT_VERSION_V1, AUTHORIZATION)
    @GET("collections/{id}/photos")
    suspend fun getPhotos(@Path("id") id: Long): List<PhotoModel>
    @Headers(ACCEPT_VERSION_V1, AUTHORIZATION)
    @GET("photos/{id}")
    suspend fun getPhoto(@Path("id") id: String): PhotoModel

    private companion object {
        private const val ACCEPT_VERSION_V1 = "Accept-Version: v1"
        private const val AUTHORIZATION = "Authorization: Client-ID FYeDd9bBkjcyekoq6pkBc0PzjPeewLJY-NcrqKZy5Jk"
    }
}