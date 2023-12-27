package com.example.foodcompose.data.repository

import android.content.Context
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.room.Dao
import com.example.foodcompose.domain.repository.FoodRepositoryDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FoodRepositoryDaoImpl @Inject constructor(
    private val dao: Dao,
    @ApplicationContext private val context: Context
): FoodRepositoryDao {
    override suspend fun getCategoriesDao(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodListByCategoryDao(category: String): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategoriesDao() {
        TODO("Not yet implemented")
    }

    override suspend fun insertCategoriesDao(list: List<Category>) {
        dao.insertCategories(list)
    }
}