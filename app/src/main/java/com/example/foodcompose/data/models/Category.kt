package com.example.foodcompose.data.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory") val idCategory: String = "",
    @SerializedName("strCategory") val strCategory: String = ""
)