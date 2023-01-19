package com.graph.randomcompose.model.api

import com.graph.randomcompose.model.response.MealCategories
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsApi {

    private var api: MealsApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealsApiInterface::class.java)
    }

    fun getMeals(): Call<MealCategories> {
        return api.getMeals()
    }

    interface MealsApiInterface {
        @GET("categories.php")
        fun getMeals(): Call<MealCategories>
    }
}