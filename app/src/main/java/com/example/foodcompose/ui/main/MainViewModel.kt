package com.example.foodcompose.ui.main

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodcompose.domain.useCase.GetCategoriesUseCase
import com.example.foodcompose.domain.useCase.GetFoodListByCategoryUseCase
import com.example.foodcompose.utils.ResultOf
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext private val application: Context,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getFoodListByCategoryUseCase: GetFoodListByCategoryUseCase
): ViewModel() {

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getCategoriesUseCase.invoke()) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        if (result.code == 0) {
                            launch(Dispatchers.Main) {
                                Toast.makeText(application, "No internet connection", Toast.LENGTH_SHORT).show()
                            }
                        }
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }
                is ResultOf.Success -> {
                    //TODO
                }
            }
        }
    }

    fun getFoodListByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getFoodListByCategoryUseCase.invoke(category = category)) {
                is ResultOf.Failure -> {
                    if (result.throwable == null) {
                        if (result.code == 0) {
                            launch(Dispatchers.Main) {
                                Toast.makeText(application, "No internet connection", Toast.LENGTH_SHORT).show()
                            }
                        }
                        Log.e("TAG", "getMovies: ${result.message}")
                    } else {
                        Log.e("TAG", "getMovies: ", result.throwable)
                    }
                }
                is ResultOf.Success -> {
                    //TODO
                }
            }
        }
    }
}