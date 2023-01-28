package com.graph.randomcompose.hilt.database

import javax.inject.Inject

class DatabaseService @Inject constructor() {

    fun log(message: String) {
        println("@@@ Database service message: $message")
    }
}