package com.mandiri.savin.api.sharedPref.module

import com.mandiri.savin.api.sharedPref.repository.UserRepository
import com.mandiri.savin.api.sharedPref.usecase.DeleteTokenUseCase
import com.mandiri.savin.api.sharedPref.usecase.GetTokenUseCase
import com.mandiri.savin.api.sharedPref.usecase.SetTokenUseCase
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
    fun provideGetTokenUseCase(repository: UserRepository) =
        GetTokenUseCase(repository)

    @Provides
    @Singleton
    fun provideSetTokenUseCase(repository: UserRepository) =
        SetTokenUseCase(repository)

    @Provides
    @Singleton
    fun provideDeleteTokenUseCase(repository: UserRepository) =
        DeleteTokenUseCase(repository)
}