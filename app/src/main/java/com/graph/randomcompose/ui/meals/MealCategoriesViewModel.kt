package com.graph.randomcompose.ui.meals

import androidx.lifecycle.ViewModel
import com.graph.randomcompose.model.MealsRepository
import com.graph.randomcompose.model.response.Category

class MealCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    fun getMeals(): List<Category> {
        return repository.getMeals().categories
    }

}
