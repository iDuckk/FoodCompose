package com.example.foodcompose.data.repository

import android.content.Context
import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Meals
import com.example.foodcompose.data.retrofit.ApiService
import com.example.foodcompose.domain.repository.FoodRepository
import com.example.foodcompose.utils.NetworkManagerConnection
import com.example.foodcompose.utils.ResultOf
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val api: ApiService,
    @ApplicationContext private val context: Context
) : FoodRepository {
    override suspend fun getCategories(): ResultOf<Categories> = coroutineScope {
        return@coroutineScope try {
            if (NetworkManagerConnection.invoke(context = context)) {
                val response = api.getCategory()
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