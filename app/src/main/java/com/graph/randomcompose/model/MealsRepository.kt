package com.graph.randomcompose.model

import com.graph.randomcompose.model.api.MealsApi
import com.graph.randomcompose.model.response.MealCategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val api: MealsApi = MealsApi()) {
    fun getMeals(
        successCallBack: (response: MealCategories?) -> Unit,
        failureCallBack: (error: String) -> Unit
    ) {
        return api.getMeals().enqueue(object: Callback<MealCategories> {
            override fun onResponse(
                call: Call<MealCategories>,
                response: Response<MealCategories>
            ) {
                if (response.isSuccessful)
                    successCallBack(response.body())
                else
                    failureCallBack(response.errorBody().toString())
            }

            override fun onFailure(call: Call<MealCategories>, t: Throwable) {
                failureCallBack(
                    "Meals API failes with ${t.message ?: t.localizedMessage ?: "No error"}"
                )
            }

        })
    }
}