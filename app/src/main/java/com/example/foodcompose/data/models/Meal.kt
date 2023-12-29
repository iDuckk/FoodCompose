package com.example.foodcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodcompose.data.models.Meal.Companion.TABLE_FOOD
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_FOOD)
data class Meal(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("idMeal") val idMeal: String = "",
    @SerializedName("strMeal") val strMeal: String = "",
    @SerializedName("strMealThumb") val strMealThumb: String = "",
    val strCategory: String = ""
) {
    companion object {
        const val TABLE_FOOD = "food"
    }
}
