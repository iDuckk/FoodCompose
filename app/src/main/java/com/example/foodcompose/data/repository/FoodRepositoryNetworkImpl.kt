package com.example.foodcompose.data.repository

import android.content.Context
import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Meals
import com.example.foodcompose.data.retrofit.ApiService
import com.example.foodcompose.data.room.Dao
import com.example.foodcompose.domain.repository.FoodRepositoryDao
import com.example.foodcompose.domain.repository.FoodRepositoryNetwork
import com.example.foodcompose.utils.NetworkManagerConnection
import com.example.foodcompose.utils.ResultOf
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class FoodRepositoryNetworkImpl @Inject constructor(
    private val api: ApiService,
    private val repoDao: FoodRepositoryDao,
    @ApplicationContext private val context: Context
) : FoodRepositoryNetwork {
    override suspend fun getCategories(): ResultOf<Categories> = coroutineScope {
        return@coroutineScope try {
            if (NetworkManagerConnection.invoke(context = context)) {
                val response = api.getCategory()
                if (response.isSuccessful) {
                    repoDao.insertCategoriesDao(response.body()!!.categories)
                    ResultOf.Success(value = response.body()!!)
                } else {
                    ResultOf.Failure(
                        message = response.message(),
                        code = response.code(),
                    )
                }
            } else {
                ResultOf.Failure(
                    message = "No internet connection",
                    code = 0
                )
            }
        } catch (e: Exception) {
            ResultOf.Failure(throwable = e)
        }
    }

    override suspend fun getFoodListByCategory(category: String): ResultOf<Meals> = coroutineScope {
        return@coroutineScope try {
            if (NetworkManagerConnection.invoke(context = context)) {
                val response = api.getFoodListByCategory(category = category)
                if (response.isSuccessful) {
                    ResultOf.Success(value = response.body()!!)
                } else {
                    ResultOf.Failure(
                        message = response.message(),
                        code = response.code(),
                    )
                }
            } else {
                ResultOf.Failure(
                    message = "No internet connection",
                    code = 0
                )
            }
        } catch (e: Exception) {
            ResultOf.Failure(throwable = e)
        }
    }
}