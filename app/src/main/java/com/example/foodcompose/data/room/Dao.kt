package com.example.foodcompose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Category.Companion.TABLE_CATEGORY
import com.example.foodcompose.data.models.Meal
import com.example.foodcompose.data.models.Meal.Companion.TABLE_FOOD

@Dao
interface Dao {
    //Category
    @Query("SELECT * FROM $TABLE_CATEGORY")
    suspend fun getAllCategories(): List<Category>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<Category>)
    @Delete
    suspend fun deleteCategories(list: List<Category>)
    //Food
    @Query("SELECT * FROM $TABLE_FOOD WHERE strCategory = :category")
    suspend fun getFoodByCategory(category: String): List<Meal>
    @Query("SELECT * FROM $TABLE_FOOD")
    suspend fun getAllFood(): List<Meal>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: List<Meal>)
    @Delete
    suspend fun deleteFood(list: List<Meal>)
}