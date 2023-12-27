package com.example.foodcompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodcompose.data.models.Category

@Database(entities = [Category::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): Dao
}