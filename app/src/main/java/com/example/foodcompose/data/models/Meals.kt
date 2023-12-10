package com.example.foodcompose.data.models

import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("meals") val mealsList: List<Meal>
)