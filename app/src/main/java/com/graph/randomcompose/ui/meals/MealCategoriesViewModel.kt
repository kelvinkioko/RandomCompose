package com.graph.randomcompose.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.graph.randomcompose.model.MealsRepository
import com.graph.randomcompose.model.response.Category
import kotlinx.coroutines.*

class MealCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
): ViewModel() {

    private val _meals: MutableState<List<Category>> = mutableStateOf(emptyList())
    val mealsCategory = _meals

    private val mealsJob = Job()

    init {
        val mealsScope = CoroutineScope(mealsJob + Dispatchers.IO)
        mealsScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            _meals.value = meals
        }
    }

    private suspend fun getMeals(): List<Category> {
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }
}

//"Meals API failes with ${t.message ?: t.localizedMessage ?: "No error"}"
