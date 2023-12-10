package com.example.foodcompose.domain.useCase

import com.example.foodcompose.domain.repository.FoodRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repo : FoodRepository) {
    suspend operator fun invoke() = repo.getCategories()
}