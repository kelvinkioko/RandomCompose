package com.graph.randomcompose.ui.meals

import androidx.lifecycle.ViewModel
import com.graph.randomcompose.model.MealsRepository

class MealCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {
}