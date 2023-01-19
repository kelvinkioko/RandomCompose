package com.graph.randomcompose.ui.meals

import androidx.lifecycle.ViewModel
import com.graph.randomcompose.model.MealsRepository
import com.graph.randomcompose.model.response.Category
import com.graph.randomcompose.model.response.MealCategories

class MealCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    private lateinit var mealCategories: MealCategories

    fun getMeals(categories: (List<Category>) -> Unit) {
        if (::mealCategories.isInitialized && mealCategories.categories.isNotEmpty()) {
            categories(mealCategories.categories)
        } else {
            repository.getMeals(
                successCallBack = { mealCategories ->
                    this.mealCategories = mealCategories ?: MealCategories()
                    categories(this.mealCategories.categories)
                },
                failureCallBack = { errorMessage ->
                    println(errorMessage)
                }
            )

        }
    }
}
