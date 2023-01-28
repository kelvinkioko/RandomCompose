package com.graph.randomcompose.download_manager

interface Downloader {
    fun downloadFile(url: String): Long
}