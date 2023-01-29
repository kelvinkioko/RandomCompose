package com.graph.randomcompose.hilt.network

import javax.inject.Inject

class InterceptorImpl @Inject constructor(): Interceptor {
    override fun log(message: String) {
        println("@@@ InterceptorImpl: $message")
    }
}