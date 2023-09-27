package com.example.wallpapers.data.net.util

import com.example.wallpapers.data.net.model.PhotoModel
import com.example.wallpapers.data.net.model.PhotosCollectionModel
import com.example.wallpapers.domain.model.Photo
import com.example.wallpapers.domain.model.PhotosCollection

fun PhotosCollectionModel.toPhotosCollection() =
    PhotosCollection(
        id = id,
        title = title,
        cover = cover.url.url
    )

fun PhotoModel.toPhoto() =
    Photo(
        id = id,
        url = url.url
    )