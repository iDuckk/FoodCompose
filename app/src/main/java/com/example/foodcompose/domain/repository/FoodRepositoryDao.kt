package com.example.foodcompose.domain.repository

import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meal
import com.example.foodcompose.data.models.Meals
import com.example.foodcompose.utils.ResultOf

interface FoodRepositoryDao {
    //Category
    suspend fun getCategoriesDao(): List<Category>
    suspend fun deleteCategoriesDao(list: List<Category>)
    suspend fun insertCategoriesDao(list: List<Category>)
    //Food
    suspend fun getFoodDao(): List<Meal>
    suspend fun getFoodListByCategoryDao(category: String): List<Meal>
    suspend fun deleteFoodDao(list: List<Meal>)
    suspend fun insertFoodDao(list: List<Meal>)
}