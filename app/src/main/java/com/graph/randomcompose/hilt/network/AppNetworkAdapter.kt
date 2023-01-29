package com.graph.randomcompose.hilt.network

import javax.inject.Inject

class AppNetworkAdapter @Inject constructor(): NetworkAdapter {
    override fun log(message: String) {
        println("@@@ AppNetworkAdapter: $message")
    }
}