package com.graph.randomcompose.model

import com.graph.randomcompose.model.response.MealCategories

class MealsRepository {
    fun getMeals(): MealCategories = MealCategories(categories = emptyList())
}