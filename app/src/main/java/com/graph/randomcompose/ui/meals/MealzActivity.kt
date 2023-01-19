package com.graph.randomcompose.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.graph.randomcompose.model.response.Category
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
    val meals: MutableState<List<Category>> = remember { mutableStateOf(emptyList()) }
    viewModel.getMeals{ categories ->
        meals.value = categories
    }

    LazyColumn {
        items(meals.value) { category ->
            Text(text = category.category)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MealsCategoriesPreview() {
    RandomComposeTheme {
        MealsCategoriesScreen()
    }
}