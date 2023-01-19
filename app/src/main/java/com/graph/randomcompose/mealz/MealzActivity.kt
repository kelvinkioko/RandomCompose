package com.graph.randomcompose.mealz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.graph.randomcompose.profile.UsersApplication
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class MealzActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                UsersApplication()
            }
        }
    }
}