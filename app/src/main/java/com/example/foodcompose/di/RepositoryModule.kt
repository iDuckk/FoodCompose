package com.example.foodcompose.di

import com.example.foodcompose.data.repository.FoodRepositoryDaoImpl
import com.example.foodcompose.data.repository.FoodRepositoryNetworkImpl
import com.example.foodcompose.domain.repository.FoodRepositoryDao
import com.example.foodcompose.domain.repository.FoodRepositoryNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class  RepositoryModule {
    @Provides
    @Singleton
    fun provideFoodRepositoryNetwork(
        repositoryImpl: FoodRepositoryNetworkImpl
    ): FoodRepositoryNetwork {
        return repositoryImpl
    }
    @Provides
    @Singleton
    fun provideFoodRepositoryDao(
        foodRepositoryDaoImpl: FoodRepositoryDaoImpl
    ): FoodRepositoryDao {
        return foodRepositoryDaoImpl
    }
}