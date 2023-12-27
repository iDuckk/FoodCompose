package com.example.foodcompose.domain.repository

import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Meals
import com.example.foodcompose.utils.ResultOf

interface  FoodRepositoryNetwork {
    suspend fun getCategories(): ResultOf<Categories>
    suspend fun getFoodListByCategory(category: String): ResultOf<Meals>
}