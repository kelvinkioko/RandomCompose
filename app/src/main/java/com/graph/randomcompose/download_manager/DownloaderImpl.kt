package com.graph.randomcompose.download_manager

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class DownloaderImpl(private val context: Context): Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String): Long {
        val request = DownloadManager
            .Request(url.toUri())
            .setMimeType("image/jpeg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("downloadImage.jpeg")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "downloadImage.jpeg")

        return downloadManager.enqueue(request)
    }
}