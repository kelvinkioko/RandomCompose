package com.graph.randomcompose.hilt.network

import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor(): Interceptor {
    override fun log(message: String) {
        println("@@@ ResponseInterceptorImpl: $message")
    }
}