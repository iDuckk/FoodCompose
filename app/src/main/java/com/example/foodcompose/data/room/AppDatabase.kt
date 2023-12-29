package com.example.foodcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meal

@Database(entities = [Category::class, Meal::class], version = 6, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): Dao
}