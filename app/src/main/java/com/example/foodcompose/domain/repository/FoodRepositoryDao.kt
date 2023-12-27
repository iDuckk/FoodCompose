package com.example.foodcompose.domain.repository

import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meals
import com.example.foodcompose.utils.ResultOf

interface FoodRepositoryDao {
    suspend fun getCategoriesDao(): List<Category>
    suspend fun getFoodListByCategoryDao(category: String): List<Category>
    suspend fun deleteCategoriesDao()
    suspend fun insertCategoriesDao(list: List<Category>)
}