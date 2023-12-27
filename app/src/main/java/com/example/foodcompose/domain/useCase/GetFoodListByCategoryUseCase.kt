package com.example.foodcompose.domain.useCase

import com.example.foodcompose.domain.repository.FoodRepositoryNetwork
import javax.inject.Inject

class GetFoodListByCategoryUseCase @Inject constructor(private val repo : FoodRepositoryNetwork) {
    suspend operator fun invoke(category: String) = repo.getFoodListByCategory(category = category)
}