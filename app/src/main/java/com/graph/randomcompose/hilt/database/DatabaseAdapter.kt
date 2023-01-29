package com.graph.randomcompose.hilt.database

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class DatabaseAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    var databaseService: DatabaseService
) {
    fun log(message: String) {
        println("@@@ Database adapter message: $message")
        databaseService.log(message = message)
        println("@@@ Database adapter context: $context")
    }
}