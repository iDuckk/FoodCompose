package com.example.foodcompose.data.models

import com.google.gson.annotations.SerializedName

data class Categories (
    @SerializedName("categories") val categories: List<Category>
)