package com.mandiri.savin.data.network.module

import com.mandiri.savin.data.network.repository.ActivityDetailsRepository
import com.mandiri.savin.data.network.repository.ActivityRepository
import com.mandiri.savin.data.network.usecase.ActivityDetailsUseCase
import com.mandiri.savin.data.network.usecase.ActivityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetActivityUseCase(repository : ActivityRepository) =
        ActivityUseCase(repository)
    @Provides
    @Singleton
    fun provideGetActivityDetailsUseCase(repository : ActivityDetailsRepository) =
        ActivityDetailsUseCase(repository)
}