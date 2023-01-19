package com.graph.randomcompose.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.graph.randomcompose.ui.theme.RandomComposeTheme

class MealzActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposeTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
private fun MealsCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()

    val meals = viewModel.getMeals()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealsCategoriesPreview() {
    RandomComposeTheme {
        MealsCategoriesScreen()
    }
}