package com.example.foodcompose.data.retrofit

import com.example.foodcompose.data.models.Categories
import com.example.foodcompose.data.models.Category
import com.example.foodcompose.data.models.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    suspend fun getCategory(): Response<Categories>

    @GET("filter.php")
    suspend fun getFoodListByCategory(
        @Query("c") category:String
    ): Response<Meals>

}