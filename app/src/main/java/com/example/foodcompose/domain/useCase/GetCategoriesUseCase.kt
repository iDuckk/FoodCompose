package com.example.foodcompose.domain.useCase

import com.example.foodcompose.domain.repository.FoodRepositoryNetwork
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repo : FoodRepositoryNetwork) {
    suspend operator fun invoke() = repo.getCategories()
}