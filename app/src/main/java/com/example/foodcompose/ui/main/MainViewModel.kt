package com.example.foodcompose.ui.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meal
import com.example.foodcompose.domain.useCase.GetCategoriesUseCase
import com.example.foodcompose.domain.useCase.GetFoodListByCategoryUseCase
import com.example.foodcompose.utils.ResultOf
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val application: Context,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getFoodListByCategoryUseCase: GetFoodListByCategoryUseCase
) : ViewModel() {

    val categories = MutableStateFlow<List<Category>?>(null)
    val foodList = MutableStateFlow<List<Meal>?>(null)
    val isSelected = MutableStateFlow<String>("Beef")
    private val toastNoInternet = Toast.makeText(
        application,
        "No internet connection",
        Toast.LENGTH_SHORT
    )

    init {
        getCategories()
        getFoodListByCategory("Beef")
    }

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getCategoriesUseCase.invoke()) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }

                is ResultOf.Success -> {
                    categories.value = async {
                        result.value.categories
                    }.await()
                }

                is ResultOf.Cache -> {
                    categories.value = async {
                        result.value.categories
                    }.await()
                    launch(Dispatchers.Main) {
                        toastNoInternet.show()
                    }
                }
            }
        }
    }

    fun getFoodListByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getFoodListByCategoryUseCase.invoke(category = category)) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }

                is ResultOf.Success -> {
                    foodList.value = async {
                        result.value.mealsList
                    }.await()
                }

                is ResultOf.Cache -> {
                    foodList.value = async {
                        result.value.mealsList
                    }.await()
                    launch(Dispatchers.Main) {
                        toastNoInternet.show()
                    }
                }
            }
        }
    }
}