package com.example.foodcompose.data.repository

import android.content.Context
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meal
import com.example.foodcompose.data.room.Dao
import com.example.foodcompose.domain.repository.FoodRepositoryDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FoodRepositoryDaoImpl @Inject constructor(
    private val dao: Dao,
    @ApplicationContext private val context: Context
): FoodRepositoryDao {
    override suspend fun getCategoriesDao(): List<Category> {
        return dao.getAllCategories()
    }

    override suspend fun deleteCategoriesDao(list: List<Category>) {
        dao.deleteCategories(list = list)
    }

    override suspend fun insertCategoriesDao(list: List<Category>) {
        dao.insertCategories(categories = list)
    }

    override suspend fun getFoodDao(): List<Meal> {
        return dao.getAllFood()
    }

    override suspend fun getFoodListByCategoryDao(category: String): List<Meal> {
        return dao.getFoodByCategory(category = category)
    }

    override suspend fun deleteFoodDao(list: List<Meal>) {
        dao.deleteFood(list)
    }

    override suspend fun insertFoodDao(list: List<Meal>) {
        dao.insertFood(food = list)
    }
}