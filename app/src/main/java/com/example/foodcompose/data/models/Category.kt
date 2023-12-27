package com.example.foodcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodcompose.data.models.Category.Companion.TABLE_CATEGORY
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_CATEGORY)
data class Category(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("idCategory") val idCategory: String = "",
    @SerializedName("strCategory") val strCategory: String = ""
) {
    companion object {
        const val TABLE_CATEGORY = "category"
    }
}