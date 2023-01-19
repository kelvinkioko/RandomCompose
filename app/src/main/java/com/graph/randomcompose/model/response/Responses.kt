package com.graph.randomcompose.model.response

data class MealCategories(
    val categories: List<Category> = emptyList()
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)
