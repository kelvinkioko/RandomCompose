package com.graph.randomcompose.model.response

import com.google.gson.annotations.SerializedName

data class MealCategories(
    @SerializedName("categories") val categories: List<Category> = emptyList()
)

data class Category(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strCategoryThumb") val categoryThumbnail: String,
    @SerializedName("strCategoryDescription") val categoryDescription: String,
)
