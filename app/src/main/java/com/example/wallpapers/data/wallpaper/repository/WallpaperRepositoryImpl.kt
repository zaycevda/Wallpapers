package com.example.wallpapers.data.wallpaper.repository

import android.app.WallpaperManager
import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.example.wallpapers.domain.repository.WallpaperRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import javax.inject.Inject

class WallpaperRepositoryImpl @Inject constructor(private val context: Context) : WallpaperRepository {
    override suspend fun setHomeScreenWallpaper(url: String) {
        try {
            val wallpaperManager = WallpaperManager.getInstance(context)
            withContext(Dispatchers.IO) {
                val bitmap = Glide.with(context).asBitmap().load(url).submit().get()
                wallpaperManager.setBitmap(bitmap)
            }
        } catch (e: IOException) {
            Log.e("WallpaperError", "${e.message}")
        }
    }

    override suspend fun setLockScreenWallpaper(url: String) {
        try {
            val wallpaperManager = WallpaperManager.getInstance(context)
            withContext(Dispatchers.IO) {
                val bitmap = Glide.with(context).asBitmap().load(url).submit().get()
                wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)
            }
        } catch (e: IOException) {
            Log.e("WallpaperError", "${e.message}")
        }
    }
}