package com.graph.randomcompose.model

import com.graph.randomcompose.model.api.MealsApi
import com.graph.randomcompose.model.response.MealCategories

class MealsRepository(private val api: MealsApi = MealsApi()) {
    suspend fun getMeals(): MealCategories {
        return api.getMeals()
    }
}