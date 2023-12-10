package com.example.foodcompose.domain.useCase

import com.example.foodcompose.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodListByCategoryUseCase @Inject constructor(private val repo : FoodRepository) {
    suspend operator fun invoke(category: String) = repo.getFoodListByCategory(category = category)
}