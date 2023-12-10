package com.example.foodcompose.di

import android.content.Context
import com.example.foodcompose.data.repository.FoodRepositoryImpl
import com.example.foodcompose.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class  RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        repositoryImpl: FoodRepositoryImpl,
        @ApplicationContext context: Context
    ): FoodRepository {
        return repositoryImpl
    }
}