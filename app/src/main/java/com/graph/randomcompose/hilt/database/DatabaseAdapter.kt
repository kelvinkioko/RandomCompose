package com.graph.randomcompose.hilt.database

import javax.inject.Inject


class DatabaseAdapter @Inject constructor(var databaseService: DatabaseService) {
    fun log(message: String) {
        println("@@@ Database adapter message: $message")
        databaseService.log(message = message)
    }
}