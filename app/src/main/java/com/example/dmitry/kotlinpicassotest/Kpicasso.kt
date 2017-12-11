package com.example.dmitry.kotlinpicassotest

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.util.LruCache
import android.widget.ImageView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.coroutines.experimental.bg

/**
 * Created by dmitry on 11/17/17.
 */
class Kpicasso(context: Context) {

    class MyLruCache(cacheSize: Int) : LruCache<String, Bitmap>(cacheSize){
        override fun sizeOf(key: String, value: Bitmap): Int {
            return value.byteCount
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak") // we have application context here, no leaks
        @Volatile private var INSTANCE: Kpicasso? = null
        fun with(context: Context): Kpicasso =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: Kpicasso(context).also { INSTANCE = it }
                }
    }

    private val mClient: OkHttpClient = OkHttpClient()
    private var cacheSize = 10 * 1024 * 1024 // 10 mb
    private val mCache = MyLruCache(cacheSize)
    private val mContext: Context = context

    private fun addImageToCache(key: String, bitmap: Bitmap) {
        if (getImageFromCache(key) == null) {
            mCache.put(key, bitmap)
        }
    }

    private fun getImageFromCache(key: String): Bitmap? {
        return mCache[key]
    }

    fun load(url: String, imageView: ImageView, placeHolderId: Int = R.drawable.ic_launcher_background) {

        // load from cache first
        if (getImageFromCache(url) != null){
            setImage(imageView, getImageFromCache(url))
            return
        }

        // load from network if not cached
        async(UI){
            try {
                val request = Request.Builder().url(url).build()
                val inputStream = bg{mClient.newCall(request)?.execute()?.body()?.byteStream()}

                val threadId = Thread.currentThread().id
                val name = Thread.currentThread().name
                Log.d("TAG", "Thread # $threadId name = $name is doing this task")

                val bitmap = BitmapFactory.decodeStream(inputStream.await())
                setImage(imageView, bitmap)
                addImageToCache(url, bitmap)
            } catch (e: Exception){
                e.printStackTrace()
                // set placeHolder
                imageView.setImageDrawable(mContext.getDrawable(placeHolderId))
            }

        }

    }

    private fun setImage(imageView: ImageView, bitmap: Bitmap?) {
        imageView.setImageBitmap(bitmap)
    }
}