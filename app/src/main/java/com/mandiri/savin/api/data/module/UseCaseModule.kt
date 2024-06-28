package com.mandiri.savin.api.data.module

import com.mandiri.savin.api.data.repository.ActivityDetailsRepository
import com.mandiri.savin.api.data.repository.ActivityRepository
import com.mandiri.savin.api.data.repository.ProfilRepository
import com.mandiri.savin.api.data.usecase.ActivityDetailsUseCase
import com.mandiri.savin.api.data.usecase.ActivityUseCase
import com.mandiri.savin.api.data.usecase.ProfilUseCase
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

    @Provides
    @Singleton
    fun provideGetProfilUseCase(repository : ProfilRepository) =
        ProfilUseCase(repository)
}