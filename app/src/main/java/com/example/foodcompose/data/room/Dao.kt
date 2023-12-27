package com.example.foodcompose.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Category.Companion.TABLE_CATEGORY

@Dao
interface Dao {
    @Query("SELECT * FROM $TABLE_CATEGORY")
    suspend fun getAllCategories(): List<Category>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<Category>)
    @Delete
    suspend fun deleteCategories(list: List<Category>)
}