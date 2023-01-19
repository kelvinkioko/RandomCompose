package com.graph.randomcompose.ui.meals

import androidx.lifecycle.ViewModel
import com.graph.randomcompose.model.MealsRepository
import com.graph.randomcompose.model.response.Category
import com.graph.randomcompose.model.response.MealCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    private lateinit var mealCategories: MealCategories

    suspend fun getMeals(): List<Category> {
        return if (::mealCategories.isInitialized && mealCategories.categories.isNotEmpty()) {
            mealCategories.categories
        } else {
            withContext(Dispatchers.IO) {
                val meals = repository.getMeals()
                mealCategories = meals
            }
            mealCategories.categories
        }
    }
}

//"Meals API failes with ${t.message ?: t.localizedMessage ?: "No error"}"
