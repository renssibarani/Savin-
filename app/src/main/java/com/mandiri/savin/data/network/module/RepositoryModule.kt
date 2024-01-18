package com.mandiri.savin.data.network.module

import com.mandiri.savin.data.network.remote.ActivityRemoteDataSource
import com.mandiri.savin.data.network.repository.ActivityRepository
import com.mandiri.savin.data.network.repository.ActivityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideActivityRepository(datasource: ActivityRemoteDataSource): ActivityRepository =
        ActivityRepositoryImpl(datasource)
}